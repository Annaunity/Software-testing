package com.lab1.thirdTask;

public class BackpackIsFullException extends RuntimeException {
    public BackpackIsFullException() {}

    public BackpackIsFullException(String message) {
        super(message);
    }
}
