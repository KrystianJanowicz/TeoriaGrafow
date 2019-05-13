package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Circle circle1 = new Circle();
        circle1.setCenterX(250.0f);
        circle1.setCenterY(135.0f);
        circle1.setRadius(100.0f);
        circle1.setFill(Color.DARKSLATEBLUE);

        Circle circle2 = new Circle();
        circle2.setCenterX(250.0f);
        circle2.setCenterY(135.0f);
        circle2.setRadius(99.0f);
        circle2.setFill(Color.BLUE);


        Shape shape = Shape.subtract(circle1, circle2);
        shape.setFill(Color.DARKSLATEBLUE);


        Group root = new Group(shape);
        Scene scene = new Scene(root, 1280, 720);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Algorytmy grafowe");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
