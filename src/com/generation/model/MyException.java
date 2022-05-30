package com.generation.model;

public class MyException extends Exception{
    String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Custom Exception{" +
                "message='" + message + '\'' +
                '}';
    }
}
