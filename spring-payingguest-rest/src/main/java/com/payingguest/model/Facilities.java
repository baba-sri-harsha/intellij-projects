package com.payingguest.model;

public enum Facilities {
    HOTWATER("Hot Water"),
    PARKING("Parking"),
    WIFI("WIFI");

    private String facilities;

    Facilities(String facilities) {
        this.facilities = facilities;
    }
}
