package com.payingguest.exceptions;

public class PayingGuestNotFoundException extends RuntimeException{

    public PayingGuestNotFoundException() {
    }

    public PayingGuestNotFoundException(String message) {
        super(message);
    }
}
