package com.example.demo1;

import javafx.beans.property.*;

public class Vehicle {
    private final StringProperty vehicleId;
    private final StringProperty brandModel;
    private final StringProperty category;
    private final DoubleProperty price;
    private final StringProperty status;

    public Vehicle(String vehicleId, String brandModel, String category, double price, String status) {
        this.vehicleId = new SimpleStringProperty(vehicleId);
        this.brandModel = new SimpleStringProperty(brandModel);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.status = new SimpleStringProperty(status);
    }

    // Getters for the properties
    public StringProperty vehicleIdProperty() { return vehicleId; }
    public StringProperty brandModelProperty() { return brandModel; }
    public StringProperty categoryProperty() { return category; }
    public DoubleProperty priceProperty() { return price; }
    public StringProperty statusProperty() { return status; }
}
