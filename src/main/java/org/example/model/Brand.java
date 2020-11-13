package org.example.model;

public class Brand {
    private long id;
    private String brand;
    private int quantity;
    private String category;
    public Brand(){};
    public Brand(String brandName, int quantity, String liquorType){
        this.brand = brandName;
        this.quantity = quantity;
        this.category = liquorType;
    }

    public Brand(long id, String brandName, int quantity, String category) {
        this.id = id;
        this.brand = brandName;
        this.quantity = quantity;
        this.category = category;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setType(String type) {
        this.category = type;
    }
}
