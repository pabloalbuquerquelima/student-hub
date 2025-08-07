package com.pabloalbuquerque.student_hub.exceptions;

public class UserFundException extends RuntimeException{
    public UserFundException() {
        super("User already exists");
    }
}
