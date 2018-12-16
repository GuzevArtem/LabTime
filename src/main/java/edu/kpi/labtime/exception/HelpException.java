package edu.kpi.labtime.exception;

public class HelpException extends LTException {
    public HelpException() {
    }

    public HelpException(String message) {
        super(message);
    }

    public HelpException(String message, Throwable cause) {
        super(message, cause);
    }

    public HelpException(Throwable cause) {
        super(cause);
    }
}
