package sample;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import java.awt.geom.Point2D;
import java.sql.SQLOutput;
import java.util.ArrayList;

import static java.lang.Math.random;
import static java.lang.StrictMath.*;
import static sun.security.krb5.Confounder.intValue;

public class Controller{

    @FXML
    private SubScene subScene;

    @FXML
    private TextField bigCircleSizeTextField;

    @FXML
    private TextField smallCirclesSizeTextField;

    @FXML
    private TextField quantityTextField;


    void markCollisions(double array[][], int quantity, int size, Group root) {
        System.out.println("--------------------------------------");
        double dis;

        for (int j = 1; j != quantity; j++) {
            for (int i = 0; i != quantity; i++) {

                if (i==j)
                    continue;

                  dis = Point2D.distance(array[i][0], array[i][1], array[j][0], array[j][1]);
                    int numberOfColors=0;
                  if (dis < size*2) {
                    Draw.drawLine(root,array, i, j);
                    if (array[i][2]==0) { //moze przypisac do j
                        array[i][2] = j;
                        //array[j][2] = i;
                        numberOfColors++;
                    }

                    System.out.println("Liczba czestotliwosci: " + numberOfColors);
                }
           }
        }
    }

    double[][] makePoints(int quantity, Group root){

        int R=GetInfoAbout.bigCircleSize(bigCircleSizeTextField);

        double[][] array = new double[quantity][3];
        for(int i=0;i<quantity;i++) {


            double a = random() * 2 * PI;
            double r = R * sqrt(random());
            double x = r * cos(a);
            double y = r * sin(a);

            //flaga czy koliduje czy nie w tablicy, najpierw sprawdzenie kolizji potem rysowanie
            array[i][0]=x;
            array[i][1]=y;
            array[i][2]=0; // if 1 it means it collides

        }
            markCollisions(array, quantity, GetInfoAbout.smallCirclesSize(smallCirclesSizeTextField), root);


        return array;
    }

    public static int diffValues(double[] numArray){
        int numOfDifferentVals = 0;

        ArrayList<Double> diffNum = new ArrayList<>();

        for(int i=0; i<numArray.length; i++){
            if(!diffNum.contains(numArray[i])){
                diffNum.add(numArray[i]);
            }
        }

        if(diffNum.size()==1){
            numOfDifferentVals = 0;
        }
        else{
            numOfDifferentVals = diffNum.size();
        }

        return numOfDifferentVals;
    }


    public void refresh(){
        Group root = new Group();

        Shape bigCircleShape =  Draw.bigCircle(GetInfoAbout.bigCircleSize(bigCircleSizeTextField));
        bigCircleShape.setFill(Color.RED);
        root.getChildren().add(bigCircleShape);

       double[][] array = makePoints(GetInfoAbout.pointsQuantity(quantityTextField), root);

        for(int i=0;i<GetInfoAbout.pointsQuantity(quantityTextField);i++) {
            Draw.smallCircles(root, GetInfoAbout.smallCirclesSize(smallCirclesSizeTextField), i, array);
        }

        double[] colisionArray= new double[GetInfoAbout.pointsQuantity(quantityTextField)];
        for(int i=0;i<GetInfoAbout.pointsQuantity(quantityTextField);i++) {
            colisionArray[i]=array[i][2];
        }

           int numberOfVals = diffValues(colisionArray);
        System.out.println("\n\n\n\n\n\n");
        if (numberOfVals==0){
            System.out.println("Liczba czestotliwosci: 1");
        } else {
            System.out.println("Liczba czestotliwosci: " + numberOfVals);
        }
        subScene.setRoot(root);
    }
}
