package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Sphere;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private SubScene subScene;
    @FXML
    private TextField RTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb){


    }

    public void refresh(){
        System.out.println("działam");

        int sizeOfCircle=160;
        Circle circle1 = new Circle();
        circle1.setCenterX(430);
        circle1.setCenterY(240.0f);
        circle1.setRadius(sizeOfCircle);
        circle1.setFill(Color.DARKSLATEBLUE);

        Circle circle2 = new Circle();
        circle2.setCenterX(430.0f);
        circle2.setCenterY(240.0f);
        circle2.setRadius(sizeOfCircle-1);

        Shape shape = Shape.subtract(circle1, circle2);
        shape.setFill(Color.DARKSLATEBLUE);


        Group root = new Group();
        root.getChildren().add(shape);
        subScene.setRoot(root);


    }
}
