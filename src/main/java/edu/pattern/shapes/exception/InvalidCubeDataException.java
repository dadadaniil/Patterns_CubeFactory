package edu.pattern.shapes.exception;

public class InvalidCubeDataException extends Exception {
    public InvalidCubeDataException() {

    }

    public InvalidCubeDataException(String message) {
        super("Invalid cube: " + message);
    }

    public InvalidCubeDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCubeDataException(Throwable cause) {
        super(cause);
    }
}