package org.example.lr5_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    @FXML
    private Button addButton;
    @FXML
    private CheckBox checkBox;
    @FXML
    private RadioButton radio1;
    @FXML
    private RadioButton radio2;
    @FXML
    private Button deleteButton;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private TableColumn<Item, String> nameColumn;

    @FXML
    private TableColumn<Item, String> orderNameColumn;

    @FXML
    private TableColumn<Item, Integer> orderPriceColumn;

    @FXML
    private TableView<Item> orderTable;

    @FXML
    private TableColumn<Item, Integer> priceColumn;


    @FXML
    private Label totalPrice;
    ObservableList<Item> menu;
    ObservableList<Item> order = FXCollections.observableArrayList();
    @FXML
    private TableView<Item> table;

    @FXML
    void addToOrder(ActionEvent event) {
        Item item = table.getSelectionModel().getSelectedItem();
        if (item != null) {
            order.add(item);
            totalPrice.setText(String.valueOf(countPrice(order)));
        }
    }

    @FXML
    void deleteFromOrder(ActionEvent event) {
        Item item = orderTable.getSelectionModel().getSelectedItem();
        order.remove(item);
        totalPrice.setText(String.valueOf(countPrice(order)));
    }

    @FXML
    void isSelected() {
        if (checkBox.isSelected()) {
            alert.setContentText("В ваш заказ добавят соус");
            alert.show();
        }
    }

    @FXML
    public void initialize() {
        alert.setTitle("Information");
        alert.setHeaderText(null);
        menu = FXCollections.observableArrayList(
                new Item("Пицца", 20),
                new Item("Стейк", 30),
                new Item("Картошка", 5),
                new Item("Рыба", 25),
                new Item("Торт", 15),
                new Item("Котлета", 10),
                new Item("Вино", 40)
        );
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(menu);
        orderNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        orderPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        orderTable.setItems(order);
        ToggleGroup group = new ToggleGroup();
        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);
        radio1.fire();
    }

    @FXML
    void isRadio1Selected() {
        if (radio1.isSelected()) {
            alert.setContentText("Вы выбрали заказ с собой");
            alert.show();
        }
    }

    @FXML
    void isRadio2Selected() {
        if (radio2.isSelected()) {
            alert.setContentText("Вы выбрали заказ на месте");
            alert.show();
        }
    }

    public int countPrice(ObservableList<Item> list) {
        int totalPrice = 0;
        for (Item item : list) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
