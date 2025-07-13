package model;

public class CatalogItem {

    // Data Members
    private String number;
    private int quantity;
    private double costPerItem;
    private double total;

    // Constructors
    public CatalogItem(
            String number,
            int quantity,
            double costPerItem,
            double total
    ) {
        this.number = number;
        this.quantity = quantity;
        this.costPerItem = costPerItem;
        this.total = total;
    }

    public CatalogItem() {
    }

    // Getters
    public String getNumber() {
        return number;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCostPerItem() {
        return costPerItem;
    }

    public double getTotal() {
        return quantity * costPerItem;
    }

    // Setters
    public void setNumber(String number) {
        this.number = number;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCostPerItem(double costPerItem) {
        this.costPerItem = costPerItem;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
