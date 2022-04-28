package com.payingguest.model;

public enum RoomShare {
    ONE("single"),
    TWO("double"),
    THREE("triple");

    private String shareType;

    RoomShare(String shareType) {
        this.shareType = shareType;
    }
}
