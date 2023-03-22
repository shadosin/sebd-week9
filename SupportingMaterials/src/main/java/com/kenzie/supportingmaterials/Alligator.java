package com.kenzie.supportingmaterials;

public class Alligator extends Animal{
    Alligator(){
        super();
        this.setNumberOfLegs(4);
        this.setSound("Silence");
    }
    public String makeSound(){
        return this.getSound();
    }
}
