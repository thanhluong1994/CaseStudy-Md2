package controller;

import model.Product;

import java.time.LocalDate;

public class ImportProduct extends Product {
    LocalDate dateAdded;

    public ImportProduct(String idProduct, String name, int price, double quantity, LocalDate dateAdded) {
        super(idProduct, name, price, quantity);
        this.dateAdded = dateAdded;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Import{" +
                "dateAdded=" + dateAdded +
                '}';
    }
}
