package com.kenzie.interfaces;


public class OnlineOrderSystem extends OrderSystem{

    public OnlineOrderSystem(Menu[] menuList, String paymentOption, Order currentOrder, Customer currentCustomer) {
        super(menuList, paymentOption, currentOrder, currentCustomer);
    }

    public void selectMenu(String menu) {
        System.out.println("Selected: " + menu);
    }

    public void makePayment(Order order) {
        System.out.println("Payment made");
    }

}
