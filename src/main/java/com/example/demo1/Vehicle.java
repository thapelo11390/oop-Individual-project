package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

// Import the Vehicle class
import com.example.demo1.Vehicle;

public class HelloController {

    @FXML
    private TextField vehicleIdField, brandModelField, categoryField, priceField;
    @FXML
    private ComboBox<String> statusBox;
    @FXML
    private TableView<Vehicle> vehicleTable;
    @FXML
    private TableColumn<Vehicle, String> idColumn, brandColumn, categoryColumn, statusColumn;
    @FXML
    private TableColumn<Vehicle, Double> priceColumn;

    private final ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(data -> data.getValue().vehicleIdProperty());
        brandColumn.setCellValueFactory(data -> data.getValue().brandModelProperty());
        categoryColumn.setCellValueFactory(data -> data.getValue().categoryProperty());
        priceColumn.setCellValueFactory(data -> data.getValue().priceProperty().asObject());
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty());

        vehicleTable.setItems(vehicleList);
    }

    @FXML
    protected void addVehicle() {
        // Validate input fields before adding
        if (!vehicleIdField.getText().isEmpty() && !brandModelField.getText().isEmpty() &&
                !categoryField.getText().isEmpty() && !priceField.getText().isEmpty() && statusBox.getValue() != null) {
            Vehicle vehicle = new Vehicle(
                    vehicleIdField.getText(),
                    brandModelField.getText(),
                    categoryField.getText(),
                    Double.parseDouble(priceField.getText()),
                    statusBox.getValue()
            );
            vehicleList.add(vehicle);

            // Clear input fields after adding
            vehicleIdField.clear();
            brandModelField.clear();
            categoryField.clear();
            priceField.clear();
            statusBox.setValue("Available");
        } else {
            // Show error message if fields are invalid
            showError("All fields must be filled!");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
