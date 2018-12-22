package edu.kpi.labtime.controller;

import edu.kpi.labtime.exception.HelpException;
import edu.kpi.labtime.exception.LTException;
import edu.kpi.labtime.exception.validation.*;
import edu.kpi.labtime.dto.Param;
import edu.kpi.labtime.exception.ShutdownException;
import edu.kpi.labtime.util.CommandGetter;
import javafx.util.Pair;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.kpi.labtime.constants.Command;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Singelton class, using for parsing CLI input.
 */
public class Parser {

    private static Parser INSTANCE = new Parser();

    /**
     * @return INSTANCE
     */
    public static Parser getInstance() {
        return INSTANCE;
    }

    /**
     * Default constructor
     */
    private Parser() {}

    private CommandGetter commandGetter = CommandGetter.getInstance();

    /**
     * @param command string to parse, must contain commandName at the beginning and all required params
     * @return Pair[Key-&gt;Command name, Value-&gt;List of parameters parsed from string]
     * @throws LTException in cases ShutdownException, HelpException, InvalidCommandNameException, ValidationException
     */
    public Pair<String,List<Param>> parseCommand(String command) throws LTException {
        String[] components = command.split("\\s+");
        checkComponents(components);
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

    /**
     * Processing special parsing for C_NEW
     * @param components array of parameters in string form
     * @return Pair[Key-&gt;Command name, Value-&gt;List of parameters parsed from string]
     * @throws ValidationException if parameters have incorrect syntax
     */
    private Pair<String,List<Param>> parseNew(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        for(int i = 1; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    /**
     * Processing special parsing for C_GET
     * @param components array of parameters in string form
     * @return Pair[Key-&gt;Command name, Value-&gt;List of parameters parsed from string]
     * @throws ValidationException if parameters have incorrect syntax
     */
    private Pair<String,List<Param>> parseGet(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        if(components.length == 1) {
            return new Pair<>(components[0], new ArrayList<>());
        }
        int firstParamToParse = 1;
        try {
            getComponentAsId(components[1], params);
            firstParamToParse++;
        }
        catch (InvalidParamTypeException ignored) {}
        for(int i = firstParamToParse; i < components.length; i++) {
            params.add(parseParam(components[0], components[i]));
        }
        return new Pair<>(components[0], params);
    }

    /**
     * Processing special parsing for C_SET
     * @param components array of parameters in string form
     * @return Pair[Key-&gt;Command name, Value-&gt;List of parameters parsed from string]
     * @throws ValidationException if parameters have incorrect syntax
     */
    private Pair<String,List<Param>> parseSet(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        getComponentAsId(components[1], params);
        for(int i = 2; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    /**
     * Processing special parsing for C_ALT
     * @param components array of parameters in string form
     * @return Pair[Key-&gt;Command name, Value-&gt;List of parameters parsed from string]
     * @throws ValidationException if parameters have incorrect syntax
     */
    private Pair<String,List<Param>> parseAlt(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        getComponentAsId(components[1], params);
        for(int i = 2; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    /**
     * Processing special parsing for C_CPY
     * @param components array of parameters in string form
     * @return Pair[Key-&gt;Command name, Value-&gt;List of parameters parsed from string]
     * @throws ValidationException if parameters have incorrect syntax
     */
    private Pair<String,List<Param>> parseCpy(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        getComponentAsId(components[1], params);
        for(int i = 2; i < components.length; i++) {
            params.add(parseParam(components[0],components[i]));
        }
        return new Pair<>(components[0], params);
    }

    /**
     * Processing special parsing for C_DEL
     * @param components array of parameters in string form
     * @return Pair[Key-&gt;Command name, Value-&gt;List of parameters parsed from string]
     * @throws ValidationException if  parameters have incorrect syntax
     */
    private Pair<String,List<Param>> parseDel(String[] components) throws ValidationException {
        List<Param> params = new ArrayList<>();
        getComponentAsId(components[1], params);
        return new Pair<>(components[0], params);
    }

    /**
     * Processing special parsing for C_GET_VALUE //todo
     * @param components array of parameters in string form
     * @return Pair[Key-&gt;Command name, Value-&gt;List of parameters parsed from string]
     * @throws ValidationException if  parameters have incorrect syntax
     */
    private Pair<String,List<Param>> parseGetValue(String[] components) throws ValidationException  {
        //todo
        throw new ValidationException(new NotImplementedException());
    }

    /**
     * @param param String containing param with structure "/{paramName}:{paramValue}"
     * @return Pair[Key-&gt;Param name, Value-&gt;Param value as String]
     * @throws InvalidParamException if param has incorrect syntax
     */
    private Pair<String,String> parseParamInput(String param) throws InvalidParamException {
        String paramName;
        String value;

        if('/' != param.charAt(0)) {
            throw new InvalidParamException("\t\'/\'not found.", param);
        }
        param = param.substring(1);
        String pv[] = param.split(":");
        if(pv.length != 2) {
            throw new InvalidParamException("\':\' not found.",param);
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

    /**
     * @param paramTemplate param template for param.getKey()
     * @param param parsed Pair[Key-&gt;Param name, Value-&gt;Param value as String]
     * @return Param
     * @throws InvalidParamTypeException if param.getValue() type are not equal or child to param type in paramTemplate
     */
    private Param parseParamValueType(Param paramTemplate, Pair<String,String> param ) throws InvalidParamTypeException {
        Param newParam = null;
        if(String.class.getName().equals(paramTemplate.getType().getName())) {
            newParam = new Param<String>(param.getKey(), param.getValue()); //value is string so no validation is required
        } else if(LocalTime.class.getName().equals(paramTemplate.getType().getName())) {
            try {
                LocalTime lt = LocalTime.parse(param.getValue());
                newParam = new Param<LocalTime>(param.getKey(), lt);
            } catch (DateTimeParseException e) {
                throw new InvalidParamTypeException(param.getValue(), e, "LocalTime");
            }
        } else if(Integer.class.getName().equals(paramTemplate.getType().getName())) {
            try {
                Integer i = Integer.parseInt(param.getValue());
                newParam = new Param<Integer>(param.getKey(), i);
            } catch (NumberFormatException e) {
                throw new InvalidParamTypeException(param.getValue(), e, "Integer");
            }
        } else if(Double.class.getName().equals(paramTemplate.getType().getName())) {
            try {
                Double d = Double.parseDouble(param.getValue());
                newParam = new Param<Double>(param.getKey(), d);
            } catch (NumberFormatException e) {
                throw new InvalidParamTypeException(param.getValue(), e, "Double");
            }
        } //todo: extend as we get more types

        return newParam;
    }


    /**
     * @param component String to parse
     * @param params to save
     * @throws InvalidParamTypeException if parse fails
     */
    private void getComponentAsId(String component, List<Param> params) throws InvalidParamTypeException {
        try {
            params.add(new Param<Integer>("Id",Integer.parseInt(component)));
        } catch (NumberFormatException e) {
            throw new InvalidParamTypeException(component, e, "Integer");
        }
    }

    /**
     * @param components String to parse splited by separator
     * @throws ValidationException if components are invalid
     */
    private void checkComponents(String[] components) throws ValidationException {
        if(components == null || components.length == 0){
            throw new ValidationException("There are no input.");
        }
        switch (components[0]) {
                case Command.C_NEW:
                    if(components.length < 2) {
                        throw new ValidationException("There are less than 2 required params.");
                    }
                    return;
                case Command.C_GET:
                    //any checks?
                    return;
                case Command.C_SET:
                    if(components.length < 2) {
                        throw new ValidationException("There are less than 2 required params.");
                    }
                    return;
                case Command.C_ALTER:
                    if(components.length < 2) {
                        throw new ValidationException("There are less than 2 required params.");
                    }
                    return;
                case Command.C_COPY:
                    if(components.length < 2) {
                        throw new ValidationException("There are less than 2 required params.");
                    }
                    return;
                case Command.C_DELETE:
                    if(components.length < 2) {
                        throw new ValidationException("There are less than 2 required params.");
                    }
                    return;
                case Command.C_GET_VALUE:
                    if(components.length < 2) {
                        throw new ValidationException("There are less than 3 required params.");
                    }
                    return;
                case Command.S_SHUTDOWN:
                case Command.S_HELP:
                    return;
                    default:
                        throw new InvalidCommandNameException("Invalid command Name: ", components[0]);
        }
    }
}
