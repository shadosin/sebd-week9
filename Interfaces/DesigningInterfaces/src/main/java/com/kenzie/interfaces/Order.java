package com.kenzie.interfaces;
public abstract class Order{
    public MenuItem[] items;
    public double total;
    public String status;
    Order(MenuItem[] items,double total,String status){
        this.items = items;
        this.total = total;
        this.status=status;
    }
    public abstract void addItem(int itemID);
    public abstract void removeItem(int itemID);
    public double getTotal(){
        return total;
    }

}