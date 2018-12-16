package edu.kpi.labtime.exception.validation;

public class InvalidParamNameException extends ValidationException {
    String paramName;

    public InvalidParamNameException(String paramName) {
        this.paramName = paramName;
    }

    public InvalidParamNameException(String message, String paramName) {
        super(message);
        this.paramName = paramName;
    }

    public InvalidParamNameException(String message, Throwable cause, String paramName) {
        super(message, cause);
        this.paramName = paramName;
    }

    public InvalidParamNameException(Throwable cause, String paramName) {
        super(cause);
        this.paramName = paramName;
    }

    @Override
    public String toString() {
        return "InvalidParamNameException{" +
                "paramName='" + paramName + '\'' +
                super.toString() +
                '}';
    }
}
