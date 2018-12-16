package edu.kpi.labtime.exception.validation;

public class InvalidParamTypeException extends ValidationException {
    String paramType;

    public InvalidParamTypeException(String paramType) {
        this.paramType = paramType;
    }

    public InvalidParamTypeException(String message, String paramType) {
        super(message);
        this.paramType = paramType;
    }

    public InvalidParamTypeException(String message, Throwable cause, String paramType) {
        super(message, cause);
        this.paramType = paramType;
    }

    public InvalidParamTypeException(Throwable cause, String paramType) {
        super(cause);
        this.paramType = paramType;
    }

    @Override
    public String toString() {
        return "InvalidParamTypeException{" +
                "paramType='" + paramType + '\'' +
                super.toString() +
                '}';
    }
}
