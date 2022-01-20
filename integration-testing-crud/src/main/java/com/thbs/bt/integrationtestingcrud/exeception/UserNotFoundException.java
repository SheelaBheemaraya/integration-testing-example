package com.thbs.bt.integrationtestingcrud.exeception;

public class UserNotFoundException  extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

}
