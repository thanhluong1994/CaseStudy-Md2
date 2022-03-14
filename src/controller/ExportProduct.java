package controller;

import model.Product;

import java.io.Serializable;
import java.time.LocalDate;

public class ExportProduct implements Serializable {
 String name;
 double quantity;
LocalDate exportDate;

    public ExportProduct(String name, double quantity, LocalDate exportDate) {
        this.name = name;
        this.quantity=quantity;
        this.exportDate = exportDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExportDate() {
        return exportDate;
    }

    public void setExportDate(LocalDate exportDate) {
        this.exportDate = exportDate;
    }

    @Override
    public String toString() {
        return "ExportProduct{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", exportDate=" + exportDate +
                '}';
    }
}
