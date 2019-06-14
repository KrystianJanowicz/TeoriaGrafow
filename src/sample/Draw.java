package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Draw {

   public static Shape bigCircle(int rCircleSize){
        Circle circle1 = new Circle();
        circle1.setCenterX(430.0f);
        circle1.setCenterY(240.0f);
        circle1.setRadius(rCircleSize);

        Circle circle2 = new Circle();
        circle2.setCenterX(430.0f);
        circle2.setCenterY(240.0f);
        circle2.setRadius(rCircleSize-1);
        Shape shape = Shape.subtract(circle1, circle2);
        return shape;
    }

    public static void smallCircles(Group root, int size, int i, double[][] array){
        Circle circle1 = new Circle();
        circle1.setCenterX(array[i][0] + 430);
        circle1.setCenterY(array[i][1] + 240);
        circle1.setRadius(size);

        Circle circle2 = new Circle();
        circle2.setCenterX(array[i][0] + 430);
        circle2.setCenterY(array[i][1] + 240);
        circle2.setRadius(size - 1);

        Circle circle3 = new Circle();
        circle3.setCenterX(array[i][0] + 430);
        circle3.setCenterY(array[i][1] + 240);
        circle3.setRadius(2);

        Shape shape = Shape.subtract(circle1, circle2);
        shape = Shape.union(shape, circle3);
        if(array[i][2]==0){
            shape.setFill(Color.GREEN);
        }
        else if (array[i][2]==1){
            shape.setFill(Color.BLUE);
        }
        else if (array[i][2] ==2){
            shape.setFill(Color.PINK);
        }
        else if (array[i][2] ==3){
            shape.setFill(Color.BROWN);
        }
        else if (array[i][2] ==4){
            shape.setFill(Color.PURPLE);
        }
        else if (array[i][2] ==5){
            shape.setFill(Color.VIOLET);
        }
        else if (array[i][2] ==6){
            shape.setFill(Color.SILVER);
        }
        else {
            shape.setFill((Color.GOLD));
        }
        root.getChildren().add(shape);
    }

    public static void drawLine(Group root, double[][] array, int i, int j){
        Line line = new Line();
        line.setStartX(array[i][0]+430);
        line.setStartY(array[i][1]+240);
        line.setEndX(array[j][0]+430);
        line.setEndY(array[j][1]+240);

        root.getChildren().add(line);
    }

}
