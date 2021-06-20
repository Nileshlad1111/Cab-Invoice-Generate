package com.bridgelabz;

public class RideRepositoryException extends Throwable {
    public enum ExceptionType {
        NULL_LIST, NO_VALUE_FOUND;
    }

    ExceptionType type;

    public RideRepositoryException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}