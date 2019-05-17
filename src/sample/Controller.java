package sample;


import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
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

    Shape drawPoints(Shape inputShape, int size){

        int R=getBigCircleSize();

        double a = random() * 2 * PI;
        double r = R * sqrt(random());
        double x = r * cos(a);
        double y = r * sin(a);

        Circle circle1 = new Circle();
        circle1.setCenterX(x + 430);
        circle1.setCenterY(y + 240);
        circle1.setRadius(size);

        Circle circle2 = new Circle();
        circle2.setCenterX(x + 430);
        circle2.setCenterY(y + 240);
        circle2.setRadius(size - 1);
        Shape shape = Shape.subtract(circle1, circle2);
        Shape outputShape = Shape.union(inputShape, shape);

        return  outputShape;

    }

    public void refresh(){
        Shape unionShape =drawBigCircle(getBigCircleSize());


        for(int i=0;i<getPointsQuantity();i++) {
            unionShape = drawPoints(unionShape, getPointsSize());
        }

        Group root = new Group();
        root.getChildren().add(unionShape);
        unionShape.setFill(Color.RED);
        subScene.setRoot(root);
    }
}
