package com.cts.userdetails.exception;

import java.util.function.Supplier;

public class EmptyDataAccessException extends Exception implements Supplier {
    public EmptyDataAccessException(String message){
        super(message);
    }

    @Override
    public Object get() {
        return "No data is found";
    }
}
