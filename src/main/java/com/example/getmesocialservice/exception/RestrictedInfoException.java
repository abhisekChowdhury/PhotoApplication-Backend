package com.example.getmesocialservice.exception;

public class RestrictedInfoException extends Exception {

    @Override
    public String getMessage() {
        return "Classified information....";
    }

}
