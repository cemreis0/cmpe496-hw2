package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    // Data Members
    private Purchaser purchaser;
    private List<CatalogItem> items;
    private double balanceOwing;

    // Constructors
    public Order(Purchaser purchaser) {
        this.purchaser = purchaser;
        this.items = new ArrayList<>();
        this.balanceOwing = 0.0;
    }

    public Order() {
    }

    // Getters
    public Purchaser getPurchaser() {
        return purchaser;
    }

    public List<CatalogItem> getItems() {
        return items;
    }

    public double getBalanceOwing() {
        return balanceOwing;
    }

    // Setters
    public void setPurchaser(Purchaser purchaser) {
        this.purchaser = purchaser;
    }

    public void setItems(List<CatalogItem> items) {
        this.items = items;
    }

    public void setBalanceOwing(double balanceOwing) {
        this.balanceOwing = balanceOwing;
    }

    // Other Methods
    public void addItem(CatalogItem catalogItem) {
        items.add(catalogItem);
    }

    public double calculateBalanceOwing()
    {
        for (CatalogItem catalogItem : items) {
            balanceOwing += catalogItem.getTotal();
        }
        return balanceOwing;
    }

}
