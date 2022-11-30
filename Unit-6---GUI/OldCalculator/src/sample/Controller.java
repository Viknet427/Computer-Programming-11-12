package sample;

import com.sun.org.apache.regexp.internal.RE;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

@SuppressWarnings("Duplicates")

public class Controller {

    public Label lblDisplay;
    public Button btnAC;
    public Button btnPercent;
    public Button btnEqual;
    public Button btnSqrt;
    public Button btnSq;
    public Button btnDivide;
    public Button btnMultiply;
    public Button btnSubtract;
    public Button btnAdd;
    public Button btnDot;
    public Button btn9;
    public Button btn8;
    public Button btn7;
    public Button btn6;
    public Button btn5;
    public Button btn4;
    public Button btn3;
    public Button btn2;
    public Button btn1;
    public Button btn0;

    public double total = 0;
    public double num = 0;
    public double num2 = 0;
    public boolean operationPressed = false;
    public boolean add = false;
    public boolean subtract = false;
    public boolean multiply = false;
    public boolean divide = false;
    public boolean sqrt = false;
    public boolean dot = false;
    public boolean percentNum = false;
    public boolean percentNum2 = false;
    public boolean sq = false;

    public void doBtn(String btnNum) {

        if (!operationPressed) {

            if (!dot) {

                int temp = (int)num;
                double temp2 = num - temp;
                num = Double.parseDouble(temp + btnNum);
                num += temp2;
                lblDisplay.setText(Double.toString(num));

            }

            else {

                int test = (int) num;
                if ((double) test == num) {

                    int temp = (int) num;
                    num = Double.parseDouble(temp + "." + btnNum);
                    lblDisplay.setText(Double.toString(num));

                } else {

                    num = Double.parseDouble(num + btnNum);
                    lblDisplay.setText(Double.toString(num));

                }

            }

        }

        else {

            if (!dot) {

                int temp = (int)num2;
                double temp2 = num2 - temp;
                num2 = Double.parseDouble(temp + btnNum);
                num2 += temp2;
                lblDisplay.setText(Double.toString(num2));

            }

            else {

                int test = (int)num2;
                if ((double)test == num2) {

                    int temp = (int)num2;
                    num2 = Double.parseDouble(temp + "." + btnNum);
                    lblDisplay.setText(Double.toString(num2));

                }

                else {

                    num2 = Double.parseDouble(num2 + btnNum);
                    lblDisplay.setText(Double.toString(num2));

                }

            }

        }

    }

    public void setBtn0(javafx.event.ActionEvent actionEvent) {

        doBtn("0");

    }

    public void setBtn1(javafx.event.ActionEvent actionEvent) {

        doBtn("1");

    }

    public void setBtn2(javafx.event.ActionEvent actionEvent) {

        doBtn("2");

    }

    public void setBtn3(javafx.event.ActionEvent actionEvent) {

        doBtn("3");

    }

    public void setBtn4(javafx.event.ActionEvent actionEvent) {

        doBtn("4");

    }

    public void setBtn5(javafx.event.ActionEvent actionEvent) {

        doBtn("5");

    }

    public void setBtn6(javafx.event.ActionEvent actionEvent) {

        doBtn("6");

    }

    public void setBtn7(javafx.event.ActionEvent actionEvent) {

        doBtn("7");

    }

    public void setBtn8(javafx.event.ActionEvent actionEvent) {

        doBtn("8");

    }

    public void setBtn9(javafx.event.ActionEvent actionEvent) {

        doBtn("9");

    }

    public void doOperation() {

        lblDisplay.setText(Double.toString(0));
        operationPressed = true;
        boolean temp = false;

        if (add) {

            total = num + num2;
            temp = true;

        }

        else if (subtract) {

            total = num - num2;
            temp = true;

        }

        else if (multiply) {

            total = num * num2;
            temp = true;

        }

        else if (divide) {

            total = num / num2;
            temp = true;

        }

        else if (sqrt) {

            total = Math.sqrt(num);
            temp = true;

        }

        else if (sq) {

            total = Math.pow(num, 2);
            temp = true;

        }

        if (temp) {

            doneOperation();

        }

    }

    public void setBtnAdd(ActionEvent actionEvent) {

        doOperation();

        add = true;

    }

    public void setBtnSubtract(ActionEvent actionEvent) {

        doOperation();

        subtract = true;

    }

    public void setBtnMultiply(ActionEvent actionEvent) {

        doOperation();

        multiply = true;

    }

    public void setBtnDivide(ActionEvent actionEvent) {

        doOperation();

        divide = true;

    }

    public void setBtnSqrt(ActionEvent actionEvent) {

        sqrt = true;

        doOperation();

    }

    public void setBtnSq(ActionEvent actionEvent) {

        sq = true;

        doOperation();

    }

    public void setBtnPercent(ActionEvent actionEvent) {

        if (num != 0 || total != 0) {

            if (!percentNum) {

                if (total == 0) {

                    num /= 100;
                    total = num;

                }

                else {

                    total /= 100;

                }

                percentNum = true;
                lblDisplay.setText(Double.toString(total));

            }

        }

    }

    public void doneOperation() {

        lblDisplay.setText(Double.toString(total));
        num = total;
        num2 = 0;
        total = 0;

        add = false;
        subtract = false;
        multiply = false;
        divide = false;
        dot = false;
        sqrt = false;
        sq = false;
        percentNum = false;
        percentNum2 = false;

    }

    public void setBtnEqual(ActionEvent actionEvent) {

        if (add) {

            total = num + num2;

        }

        else if (subtract) {

            total = num - num2;

        }

        else if (multiply) {

            total = num * num2;

        }

        else if (divide) {

            total = num / num2;

        }

        else if (sqrt) {

            total = Math.sqrt(num);

        }

        else {

            total = num;

        }

        doneOperation();
        operationPressed = false;

    }

    public void setBtnAC(ActionEvent actionEvent) {

        lblDisplay.setText(Double.toString(0));
        total = 0;
        num = 0;
        num2 = 0;
        operationPressed = false;
        add = false;
        subtract = false;
        multiply = false;
        divide = false;
        dot = false;
        sqrt = false;
        percentNum = false;
        percentNum2 = false;

    }

    public void setBtnDot(ActionEvent actionEvent) {

        dot = true;

    }

}
