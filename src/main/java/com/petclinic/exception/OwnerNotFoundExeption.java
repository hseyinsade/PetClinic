package com.petclinic.exception;

public class OwnerNotFoundExeption extends RuntimeException {
    public OwnerNotFoundExeption(String message) {
        super(message);
    }
}
