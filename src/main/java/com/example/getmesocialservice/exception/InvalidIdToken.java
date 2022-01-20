package com.example.getmesocialservice.exception;

public class InvalidIdToken extends Exception {

        @Override
        public String getMessage() {
            return "Invalid IdToken";
        }
    }
