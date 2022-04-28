package com.furnapp.model;

public enum Material {
    TWOOD(1,"TEAK WOOD"),
    PLASTIC(2,"PLASTIC"),
    SWOOD(3,"SEESHAMWOOD"),
    MWOOD(4,"MANGO WOOD"),
    FOAM(4,"FOAM MATTRESS");

    public int grade;
    public String type;

    Material(int grade, String type){
        this.grade=grade;
        this.type=type;

    }


}
