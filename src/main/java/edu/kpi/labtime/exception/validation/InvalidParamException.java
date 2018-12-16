package edu.kpi.labtime.exception.validation;

public class InvalidParamException extends ValidationException {
    String paramName;

    public InvalidParamException(String paramName) {
        this.paramName = paramName;
    }

    public InvalidParamException(String message, String paramName) {
        super(message);
        this.paramName = paramName;
    }

    public InvalidParamException(String message, Throwable cause, String paramName) {
        super(message, cause);
        this.paramName = paramName;
    }

    public InvalidParamException(Throwable cause, String paramName) {
        super(cause);
        this.paramName = paramName;
    }

    @Override
    public String toString() {
        return "InvalidParamException{" +
                "paramName='" + paramName + '\'' +
                super.toString() +
                '}';
    }
}
