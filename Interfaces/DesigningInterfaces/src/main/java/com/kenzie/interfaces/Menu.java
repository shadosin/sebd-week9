package com.kenzie.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public abstract class Menu{
    public String name;
    public ArrayList<MenuItem> items;

    Menu(String name, ArrayList<MenuItem> items){
        this.name = name;
        this.items = new ArrayList<>();
    }
    public abstract void displayMenu();


    public abstract void addItem(int itemID);


    public abstract void removeItem(int itemID);
}

