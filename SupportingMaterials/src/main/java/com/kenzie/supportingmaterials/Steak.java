package com.kenzie.supportingmaterials;

public class Steak extends MenuItem{

    @Override
    public double getPrice() {
        return 8.99;
    }

    @Override
    public void setPrice(double price) {
        this.price = price + 3.00;
    }

    @Override
    public void removeItem(int itemID) {
        System.out.println(itemID);
    }
}
