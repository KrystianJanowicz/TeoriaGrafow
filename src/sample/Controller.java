package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
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

import static java.lang.Math.random;
import static java.lang.StrictMath.*;

public class Controller{

    @FXML
    private SubScene subScene;

    @FXML
    private TextField RCircleSizeTextField;

    int getRCircleSize(){
        int RCircleSize;
        if (RCircleSizeTextField.getText().isEmpty()) {
            RCircleSize=0;
        }
        else {
            RCircleSize = Integer.parseInt(RCircleSizeTextField.getText());
        }
        return RCircleSize;
    }

    void drawBigCircle(int rCircleSize){
        Circle circle1 = new Circle();
        circle1.setCenterX(430);
        circle1.setCenterY(240.0f);
        circle1.setRadius(rCircleSize);
        circle1.setFill(Color.DARKSLATEBLUE);

        Circle circle2 = new Circle();
        circle2.setCenterX(430.0f);
        circle2.setCenterY(240.0f);
        circle2.setRadius(rCircleSize-1);
        Shape shape = Shape.subtract(circle1, circle2);
        shape.setFill(Color.DARKSLATEBLUE);
        Group root = new Group();
        root.getChildren().add(shape);
        subScene.setRoot(root);
    }

    public void refresh(){
        drawBigCircle(getRCircleSize());


        int R=getRCircleSize();
        double a = random() * 2 * PI;
        double r = R * sqrt(random());

// TO DO: TU SKOŃCZYŁEŚ, GENERUJE LOSOWE PUNKTY W KOLE, TERAZ ŻEBY DWA KOŁA NA RAZ NARYSOWAŁO
        double x = r * cos(a);
        double y = r * sin(a);
        Circle circle1 = new Circle();
        circle1.setCenterX(x+430);
        circle1.setCenterY(y+240);
        circle1.setRadius(6);
        circle1.setFill(Color.DARKSLATEBLUE);

        Circle circle2 = new Circle();
        circle2.setCenterX(x+430);
        circle2.setCenterY(y+240);
        circle2.setRadius(1-1);
        Shape shape = Shape.subtract(circle1, circle2);
        shape.setFill(Color.DARKSLATEBLUE);
        Group root = new Group();
        root.getChildren().add(shape);
        subScene.setRoot(root);
    }
}
