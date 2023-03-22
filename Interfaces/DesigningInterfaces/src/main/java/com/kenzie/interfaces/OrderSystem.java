package com.kenzie.interfaces;
public abstract class OrderSystem{
    public Menu[] menuList;
    public String paymentOption;
    public Order currentOrder;
    public Customer currentCustomer;

    OrderSystem(Menu []menuList, String paymentOption, Order currentOrder, Customer currentCustomer){

    }
    public abstract void selectMenu(String menu);


    public abstract void makePayment(Order order);


}