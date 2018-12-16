package edu.kpi.labtime.controller;

import edu.kpi.labtime.exception.HelpException;
import edu.kpi.labtime.exception.LTException;
import edu.kpi.labtime.exception.validation.*;
import edu.kpi.labtime.model.Param;
import edu.kpi.labtime.exception.ShutdownException;
import edu.kpi.labtime.util.CommandGetter;
import javafx.util.Pair;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.kpi.labtime.constants.Command;

public class Parser {

    private static Parser INSTANCE = new Parser();

    public static Parser getInstance() {
        return INSTANCE;
    }

    private Parser() {}

    private CommandGetter commandGetter = CommandGetter.getInstance();

    public Pair<String,List<Param>> parseCommand(String command) throws LTException {
        String[] components = command.split("\\s+");
        String commandName = components[0];
        switch (commandName) {
            case Command.C_NEW:
                return parseNew(components);
            case Command.C_GET:
                return parseGet(components);
            case Command.C_SET:
                return parseSet(components);
            case Command.C_ALTER:
                return parseAlt(components);
            case Command.C_COPY:
                return parseCpy(components);
            case Command.C_DELETE:
                return parseDel(components);
            case Command.C_GET_VALUE:
                return parseGetValue(components);
            case Command.S_SHUTDOWN:
                throw new ShutdownException("Recieved shutdown command.");
            case Command.S_HELP:
                throw new HelpException("Recieved help command.");
        }
        throw new InvalidCommandNameException(commandName);
    }

    private Pair<String,List<Param>> parseNew(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        for(int i = 1; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    private Pair<String,List<Param>> parseGet(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        params.add(new Param<Integer>("Id",Integer.parseInt(components[1])));
        for(int i = 2; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    private Pair<String,List<Param>> parseSet(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        params.add(new Param<Integer>("Id",Integer.parseInt(components[1])));
        for(int i = 2; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    private Pair<String,List<Param>> parseAlt(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        params.add(new Param<Integer>("Id",Integer.parseInt(components[1])));
        for(int i = 2; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    private Pair<String,List<Param>> parseCpy(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        params.add(new Param<Integer>("Id",Integer.parseInt(components[1])));
        for(int i = 2; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    private Pair<String,List<Param>> parseDel(String[] components) {
        List<Param> params = new ArrayList<>();
        params.add(new Param<Integer>("Id",Integer.parseInt(components[1])));
        return new Pair<>(components[0], params);
    }

    private Pair<String,List<Param>> parseGetValue(String[] components) {
        //todo
        return null;
    }

    private Pair<String,String> parseParamInput(String param) throws InvalidParamException {
        String paramName;
        String value;

        if('/' != param.charAt(0)) {
            throw new InvalidParamException(param, "\'/\'not found.");
        }
        param = param.substring(1);
        String pv[] = param.split(":");
        if(pv.length != 2) {
            throw new InvalidParamException(param,"\':\' not found.");
        }
        paramName = pv[0];
        value = pv[1];//todo: parse complicated value
        return new Pair<String, String>(paramName,value);
    }

    private Param parseParam(String paramName, String component) throws ValidationException {
        Pair<String, String> param = parseParamInput(component);
        List<Param> commandParams = commandGetter.getCommands().get(paramName);
        Param foundedParam = null;
        try {
            foundedParam = commandParams.stream().filter(x -> x.getName().equals(param.getKey())).findFirst().get();
        } catch (NoSuchElementException e) {
            throw new InvalidParamNameException("Invalid param name.",e,param.getKey());
        }
        return (parseParamValueType(foundedParam,param));
    }

    private Param parseParamValueType(Param foundedParam, Pair<String,String> param ) throws InvalidParamTypeException {
        Param newParam = null;
        if(String.class.getName().equals(foundedParam.getType().getName())) {
            newParam = new Param<String>(param.getKey(), param.getValue()); //value is string so no validation is required
        } else if(LocalTime.class.getName().equals(foundedParam.getType().getName())) {
            try {
                LocalTime lt = LocalTime.parse(param.getValue());
                newParam = new Param<LocalTime>(param.getKey(), lt);
            } catch (DateTimeParseException e) {
                throw new InvalidParamTypeException(param.getValue(), e, "LocalTime");
            }
        } else if(Integer.class.getName().equals(foundedParam.getType().getName())) {
            try {
                Integer i = Integer.parseInt(param.getValue());
                newParam = new Param<Integer>(param.getKey(), i);
            } catch (NumberFormatException e) {
                throw new InvalidParamTypeException(param.getValue(), e, "Integer");
            }
        } else if(Double.class.getName().equals(foundedParam.getType().getName())) {
            try {
                Double d = Double.parseDouble(param.getValue());
                newParam = new Param<Double>(param.getKey(), d);
            } catch (NumberFormatException e) {
                throw new InvalidParamTypeException(param.getValue(), e, "Double");
            }
        } //todo extend

        return newParam;
    }
}
