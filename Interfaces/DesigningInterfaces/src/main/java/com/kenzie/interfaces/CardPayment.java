package com.kenzie.interfaces;



public class CardPayment implements Payment {
    public void confirmPayment(double payment) {
        System.out.println("Payment confirmed");
    }
    public void printReceipt(){
        System.out.println("Receipt displayed");
    }
}
