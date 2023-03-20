package com.kenzie.interfaces;

public abstract class MenuItem{
    private int itemID;
    private String name;
    private double price;

    public MenuItem(int itemID, String name, double price){
        this.itemID = itemID;
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double p){
        price = p;
    }

    public abstract void removeItem(int itemID);

}