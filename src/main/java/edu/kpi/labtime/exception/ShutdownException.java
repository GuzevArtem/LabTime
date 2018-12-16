package edu.kpi.labtime.exception;

public class ShutdownException extends LTException {
    public ShutdownException() {
    }

    public ShutdownException(String message) {
        super(message);
    }

    public ShutdownException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShutdownException(Throwable cause) {
        super(cause);
    }
}
