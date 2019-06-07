package sample;


import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.awt.geom.Point2D;

import static java.lang.Math.random;
import static java.lang.StrictMath.*;

public class Controller{

    @FXML
    private SubScene subScene;

    @FXML
    private TextField bigCircleSizeTextField;

    @FXML
    private TextField pointsSizeTextField;

    @FXML
    private TextField quantityTextField;

    int getBigCircleSize(){
        int bigCircleSize;
        if (bigCircleSizeTextField.getText().isEmpty()) {
            bigCircleSize=0;
        }
        else {
            bigCircleSize = Integer.parseInt(bigCircleSizeTextField.getText());
        }
        return bigCircleSize;
    }
    
    int getPointsQuantity(){
        int quantity;
        if(quantityTextField.getText().isEmpty()){
            quantity=0;
        }
        else {
            quantity = Integer.parseInt(quantityTextField.getText());
        }
        return quantity;
    }

    int getPointsSize(){
        int size;
        if(pointsSizeTextField.getText().isEmpty()){
            size=0;
        }
        else {
            size = Integer.parseInt(pointsSizeTextField.getText());
        }
        return size;
    }

    void markCollisions(double array[][], int quantity, int size) {
        System.out.println("--------------------------------------");
        double dis;
        for (int j = 1; j != quantity; j++) {
            System.out.println("j: " + j);
            for (int i = 0; i != quantity; i++) {
                System.out.println("i: " + i);

                if (i==j)
                    continue;

       dis = Point2D.distance(array[i][0], array[i][1], array[j][0], array[j][1]);


                System.out.println("dystans: "+ dis);
                if (dis < size*2) {
                    System.out.println("kolizja");
                }
           }
        }
    }

    Shape drawBigCircle(int rCircleSize){
        Circle circle1 = new Circle();
        circle1.setCenterX(430);
        circle1.setCenterY(240.0f);
        circle1.setRadius(rCircleSize);

        Circle circle2 = new Circle();
        circle2.setCenterX(430.0f);
        circle2.setCenterY(240.0f);
        circle2.setRadius(rCircleSize-1);
        Shape shape = Shape.subtract(circle1, circle2);
        return shape;
    }


    double[][] makePoints(int quantity){

        int R=getBigCircleSize();

        double[][] array = new double[quantity][2];
        for(int i=0;i<quantity;i++) {


            double a = random() * 2 * PI;
            double r = R * sqrt(random());
            double x = r * cos(a);
            double y = r * sin(a);

           // System.out.println("x:" + x + "y:" +y);
            //flaga czy koliduje czy nie w tablicy, najpierw sprawdzenie kolizji potem rysowanie
            array[i][0]=x;
            array[i][1]=y;

        }

            markCollisions(array, quantity, getPointsSize());


        return array;
    }

    void drawPoints(Group root, int size, double x, double y){


        Circle circle1 = new Circle();
        circle1.setCenterX(x + 430);
        circle1.setCenterY(y + 240);
        circle1.setRadius(size);

        Circle circle2 = new Circle();
        circle2.setCenterX(x + 430);
        circle2.setCenterY(y + 240);
        circle2.setRadius(size - 1);

        Shape shape = Shape.subtract(circle1, circle2);
        shape.setFill(Color.GREEN);
        root.getChildren().add(shape);
    }

    public void refresh(){
        Group root = new Group();

        Shape bigCircleShape =drawBigCircle(getBigCircleSize());
        bigCircleShape.setFill(Color.RED);
        root.getChildren().add(bigCircleShape);

       double[][] array = makePoints(getPointsQuantity());

        for(int i=0;i<getPointsQuantity();i++) {
            drawPoints(root, getPointsSize(), array[i][0], array[i][1]);
        }

        subScene.setRoot(root);
    }
}
