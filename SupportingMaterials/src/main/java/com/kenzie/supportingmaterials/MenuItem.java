package com.kenzie.supportingmaterials;

abstract class MenuItem {
    public int itemID;
    public String name;
    public double price;
    public String availability;

 public abstract double getPrice();
 public abstract void setPrice(double price);
 public abstract void removeItem(int itemID);
}
