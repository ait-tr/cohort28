package ait.exception;

public class SolutionAnyNumberException extends RuntimeException {
    String message;

    public SolutionAnyNumberException() {
        super();
    }

    public SolutionAnyNumberException(String message) {
        super(message);
    }
}
