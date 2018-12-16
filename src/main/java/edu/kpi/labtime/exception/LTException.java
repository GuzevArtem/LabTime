package edu.kpi.labtime.exception;

public class LTException extends Exception {

    public LTException() {
    }

    public LTException(String message) {
        super(message);
    }

    public LTException(String message, Throwable cause) {
        super(message, cause);
    }

    public LTException(Throwable cause) {
        super(cause);
    }

    public LTException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
