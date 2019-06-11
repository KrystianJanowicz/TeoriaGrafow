package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Draw {

   public static Shape bigCircle(int rCircleSize){
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

    public static void smallCircles(Group root, int size, double x, double y){
        Circle circle1 = new Circle();
        circle1.setCenterX(x + 430);
        circle1.setCenterY(y + 240);
        circle1.setRadius(size);

        Circle circle2 = new Circle();
        circle2.setCenterX(x + 430);
        circle2.setCenterY(y + 240);
        circle2.setRadius(size - 1);

        Circle circle3 = new Circle();
        circle3.setCenterX(x + 430);
        circle3.setCenterY(y + 240);
        circle3.setRadius(2);

        Shape shape = Shape.subtract(circle1, circle2);
        shape = Shape.union(shape, circle3);
        shape.setFill(Color.GREEN);
        root.getChildren().add(shape);
    }

    public static void drawLine(Group root, double[][] array, int i, int j){
        Line line = new Line();
        line.setStartX(array[i][0]+430);
        System.out.println("wartosc array[i][0]:"+array[i][0] + " i: " + i);
        System.out.println("wartosc array[j][0]:"+array[j][0] + " j: " + j);
        System.out.println("wartosc array[i][1]:"+array[i][1] + " i: " + i);
        System.out.println("wartosc array[j][1]:"+array[j][1] + " j: " + j);
        line.setStartY(array[i][1]+240);
        line.setEndX(array[j][0]+430);
        line.setEndY(array[j][0]+240);

        root.getChildren().add(line);
    }

}
