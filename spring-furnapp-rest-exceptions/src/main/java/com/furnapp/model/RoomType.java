package com.furnapp.model;

public enum RoomType {
    BED("Bedrooms"),OFFICE("office room"),DINING("Dining room"),STUDY("Study Room"),KIDS("kids room"),LIVING("living room");

    public String type;

    RoomType(String type){
        this.type=type;
    }
}
