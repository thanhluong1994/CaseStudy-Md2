package controller;

import model.Product;

import java.time.LocalDate;

public class ExportProduct extends Product {
LocalDate exportDate;

    public ExportProduct(String idProduct, String name, int price, double quantity, LocalDate exportDate) {
        super(idProduct, name, price, quantity);
        this.exportDate = exportDate;
    }

    public LocalDate getExportDate() {
        return exportDate;
    }

    public void setExportDate(LocalDate exportDate) {
        this.exportDate = exportDate;
    }

    @Override
    public String toString() {
        return "Export{" +
                "exportDate=" + exportDate +
                '}';
    }
}
