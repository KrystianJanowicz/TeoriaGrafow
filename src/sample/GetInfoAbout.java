package sample;


import javafx.scene.control.TextField;

public class GetInfoAbout {

    public static int bigCircleSize(TextField bigCircleSizeTextField){
        int bigCircleSize;
        if (bigCircleSizeTextField.getText().isEmpty()) {
            bigCircleSize=0;
        }
        else {
            bigCircleSize = Integer.parseInt(bigCircleSizeTextField.getText());
        }
        return bigCircleSize;
    }

    public static int smallCirclesSize(TextField smallCirclesSizeTextField){
        int size;
        if(smallCirclesSizeTextField.getText().isEmpty()){
            size=0;
        }
        else {
            size = Integer.parseInt(smallCirclesSizeTextField.getText());
        }
        return size;
    }

   public static int pointsQuantity(TextField quantityTextField){
        int quantity;
        if(quantityTextField.getText().isEmpty()){
            quantity=0;
        }
        else {
            quantity = Integer.parseInt(quantityTextField.getText());
        }
        return quantity;
    }



}
