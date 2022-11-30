package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Controller {

    public Label displayOperations;
    public Label display;

    ArrayList<Integer> integers = new ArrayList<>();
    ArrayList<String> operators = new ArrayList<>();
    ArrayList<Double> doubles = new ArrayList<>();

    StringBuilder numBuilder = new StringBuilder();
    double num1 = 0;
    double num2 = 0;


    public void btnNum(int num) {

        integers.add(num);

        for (int i = 0; i < integers.size(); i++) {

            numBuilder.append(integers.get(i));

        }

        display.setText(numBuilder.toString());
        numBuilder.delete(0, numBuilder.length());

    }

    public void btnOp(String op) {

        integers.clear();
        operators.add(op);

    }

    public void clear() {
    }

    public void sqrt(ActionEvent actionEvent) {
    }

    public void sq(ActionEvent actionEvent) {
    }

    public void percent(ActionEvent actionEvent) {
    }

    public void allClear(ActionEvent actionEvent) {
    }

    public void divide(ActionEvent actionEvent) {

        btnOp("/");

    }

    public void multiply(ActionEvent actionEvent) {

        btnOp("*");

    }

    public void minus(ActionEvent actionEvent) {

        btnOp("-");

    }

    public void add(ActionEvent actionEvent) {

        btnOp("+");

    }

    public void equals(ActionEvent actionEvent) {
    }

    public void dot(ActionEvent actionEvent) {
    }

    public void btn0(ActionEvent actionEvent) { btnNum(0); }

    public void btn1(ActionEvent actionEvent) { btnNum(1); }

    public void btn2(ActionEvent actionEvent) { btnNum(2); }

    public void btn3(ActionEvent actionEvent) { btnNum(3); }

    public void btn4(ActionEvent actionEvent) { btnNum(4); }

    public void btn5(ActionEvent actionEvent) { btnNum(5); }

    public void btn6(ActionEvent actionEvent) { btnNum(6); }

    public void btn7(ActionEvent actionEvent) { btnNum(7); }

    public void btn8(ActionEvent actionEvent) { btnNum(8); }

    public void btn9(ActionEvent actionEvent) { btnNum(9); }

}
