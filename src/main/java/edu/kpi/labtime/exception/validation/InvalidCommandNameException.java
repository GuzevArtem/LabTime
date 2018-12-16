package edu.kpi.labtime.exception.validation;

public class InvalidCommandNameException extends ValidationException {
    String commandName;

    public InvalidCommandNameException(String commandName) {
        this.commandName = commandName;
    }

    public InvalidCommandNameException(String message, String commandName) {
        super(message);
        this.commandName = commandName;
    }

    public InvalidCommandNameException(String message, Throwable cause, String commandName) {
        super(message, cause);
        this.commandName = commandName;
    }

    public InvalidCommandNameException(Throwable cause, String commandName) {
        super(cause);
        this.commandName = commandName;
    }

    @Override
    public String toString() {
        return "InvalidCommandNameException{" +
                "commandName='" + commandName + '\'' +
                super.toString() +
                '}';
    }
}
