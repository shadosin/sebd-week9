package com.kenzie.supportingmaterials;

public abstract class Animal {
    private int numberOfLegs;
    private String sound;
    public void setNumberOfLegs(int numberOfLegs){
        this.numberOfLegs = numberOfLegs;
    }
    public void setSound(String sound){
        this.sound = sound;
    }
    public String getSound(){
        return sound;
    }
    public abstract String makeSound();
}
