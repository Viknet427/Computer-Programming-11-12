package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    public TextField textGetName;
    public TextField textGetQuantity;
    public TextField textGetCost;
    public ListView<Product> productList = new ListView<>();
    public Label lblName;
    public Label lblQuantity;
    public Label lblCost;
    public Button btnPurchase;

    public void addProduct(ActionEvent actionEvent) {

        String name = textGetName.getText();
        int quant = Integer.parseInt(textGetQuantity.getText());
        double cost = Double.parseDouble(textGetCost.getText());
        Product temp = new Product(name, quant, cost);

        productList.getItems().add(temp);
        textGetName.clear();
        textGetQuantity.clear();
        textGetCost.clear();

        btnPurchase.setDisable(true);

    }

    public void displayProduct(MouseEvent mouseEvent) {

        Product temp;
        temp = productList.getSelectionModel().getSelectedItem();
        lblCost.setText("$" + Double.toString(temp.getCost()));
        lblName.setText(temp.name);
        lblQuantity.setText(Integer.toString(temp.getQuantity()));

        btnPurchase.setDisable(false);

    }

    public void purchaseProduct(ActionEvent actionEvent) {

        Product temp;
        temp = productList.getSelectionModel().getSelectedItem();
        temp.purchase();
        lblQuantity.setText(Integer.toString(temp.getQuantity()));

    }

}
