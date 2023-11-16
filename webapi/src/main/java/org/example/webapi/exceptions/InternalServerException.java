package org.example.webapi.exceptions;

public class InternalServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InternalServerException(String message) {
        super(message);
    }
}
