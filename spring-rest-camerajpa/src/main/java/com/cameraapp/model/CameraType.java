package com.cameraapp.model;

public enum CameraType {
    DSLR("DSLR"),
    SLR("SLR"),
    POINT("POINT"),
    MIRRORLESS("MIRRORLESS"),
    SHOOT("SHOOT");

    private String type;

    CameraType(String type) {
        this.type = type;
    }
}
