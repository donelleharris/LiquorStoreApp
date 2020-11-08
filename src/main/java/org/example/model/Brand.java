package org.example.model;

public class Brand {
    private String brand;
    private int quantity;
    private String type;
    public Brand(){};
    public Brand(String brandName, int quantity, String liquorType){
        this.brand = brandName;
        this.quantity = quantity;
        this.type = liquorType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
