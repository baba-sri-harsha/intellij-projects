package com.cameraapp.model;

public enum LensType {
    ZOOM("ZOOM"),
    WIDEANGLE("WIDE ANGLE"),
    PRIME("PRIME"),
    TELEPHOTO("TELEPHOTO");

    private  String lens;

    LensType(String lens) {
        this.lens = lens;
    }
}
