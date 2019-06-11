package sample;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
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
    private TextField smallCirclesSizeTextField;

    @FXML
    private TextField quantityTextField;


    void markCollisions(double array[][], int quantity, int size, Group root) {
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
                    Draw.drawLine(root,array, i, j);
                    System.out.println("kolizja");
                }
           }
        }
    }

    double[][] makePoints(int quantity, Group root){

        int R=GetInfoAbout.bigCircleSize(bigCircleSizeTextField);

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

            markCollisions(array, quantity, GetInfoAbout.smallCirclesSize(smallCirclesSizeTextField), root);


        return array;
    }



    public void refresh(){
        Group root = new Group();

        Shape bigCircleShape =  Draw.bigCircle(GetInfoAbout.bigCircleSize(bigCircleSizeTextField));
        bigCircleShape.setFill(Color.RED);
        root.getChildren().add(bigCircleShape);

       double[][] array = makePoints(GetInfoAbout.pointsQuantity(quantityTextField), root);

        for(int i=0;i<GetInfoAbout.pointsQuantity(quantityTextField);i++) {
            Draw.smallCircles(root, GetInfoAbout.smallCirclesSize(smallCirclesSizeTextField), array[i][0], array[i][1]);
        }

        subScene.setRoot(root);
    }
}
