package org.group28projectjpa.core.validation;

public class IsAlreadyExistException extends RuntimeException {

    public IsAlreadyExistException(String message) {
        super(message);
    }
}
