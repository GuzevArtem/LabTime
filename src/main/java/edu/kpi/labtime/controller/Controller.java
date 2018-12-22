package edu.kpi.labtime.controller;

import edu.kpi.labtime.constants.Command;
import edu.kpi.labtime.constants.Constants;
import edu.kpi.labtime.dto.Lab;
import edu.kpi.labtime.dto.result.ResultLab;
import edu.kpi.labtime.exception.HelpException;
import edu.kpi.labtime.exception.LTException;
import edu.kpi.labtime.exception.ShutdownException;
import edu.kpi.labtime.exception.validation.ValidationException;
import edu.kpi.labtime.dto.Param;
import edu.kpi.labtime.dto.result.Result;
import edu.kpi.labtime.dto.result.ResultString;
import edu.kpi.labtime.util.CommandGetter;
import edu.kpi.labtime.view.View;
import javafx.util.Pair;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Parser parser = Parser.getInstance();
    private View view = View.getInstance();

    private Scanner sc = new Scanner(System.in);

    public void run() {
        view.display("WELCOME TO LABTIME");
        String input;
        while(true) {
            input = sc.nextLine();
            if(input.length() == 0) {
                continue;
            }
            try {
                Pair<String,List<Param>> command = parseInput(input);
                Result result = execute(command);
                view.display(result);
            } catch (ShutdownException e) {
                break;
            } catch (HelpException e) {
                view.display(Constants.HELP_INFO);
            } catch (ValidationException e) {
                view.displayError(e.toString());
            } catch (Exception e) {
                view.displayError(e.getMessage());
                //log e.printStackTrace();
            }
        }
        view.display("LABS WILL WAIT FOR YOU");
    }

    public Pair<String,List<Param>> parseInput(String input) throws LTException {
        return parser.parseCommand(input);
    }

    public Result execute(Pair<String,List<Param>> command){
        return execute(command.getKey(),command.getValue());
    }

    public Result execute(String command, List<Param> params){
        switch (command) {
            case Command.C_NEW:
                return executeNew(params);
            case Command.C_GET:
                return executeGet(params);
            case Command.C_SET:
                return executeSet(params);
            case Command.C_ALTER:
                return executeAlter(params);
            case Command.C_COPY:
                return executeCopy(params);
            case Command.C_DELETE:
                return executeDelete(params);
            case Command.C_GET_VALUE:
        }
        return new ResultString("NO BUSINESS LOGIC STILL");
    }

    private Result executeNew(List<Param> params) {
        Lab lab = new Lab();
        for(Param p : params) {
            setParam(lab, p);
        }
        //save to db
        return new ResultLab(lab);
    }

    private Result executeGet(List<Param> params) {
        return new ResultString("NO BUSINESS LOGIC STILL");
    }

    private Result executeSet(List<Param> params) {
        return new ResultString("NO BUSINESS LOGIC STILL");
    }

    private Result executeAlter(List<Param> params) {
        return new ResultString("NO BUSINESS LOGIC STILL");
    }

    private Result executeCopy(List<Param> params) {
        return new ResultString("NO BUSINESS LOGIC STILL");
    }

    private Result executeDelete(List<Param> params) {
        return new ResultString("NO BUSINESS LOGIC STILL");
    }


    private void setParam(Lab lab, Param param) {
        switch (param.getName()) {
            case CommandGetter.LAB_SUBJECT_STR:
                lab.setSubject((String) param.getValue());
                break;
            case CommandGetter.LAB_NUMBER_STR:
                lab.setNumber((Integer) param.getValue());
                break;
            case CommandGetter.LAB_DESCRIPTION_STR:
                lab.setDescription((String) param.getValue());
                break;
            case CommandGetter.LAB_TASK_STR:
                lab.setTask((String) param.getValue());
                break;
            case CommandGetter.LAB_REQUIREMENTS_STR:
                lab.setRequirements((String) param.getValue());
                break;
            case CommandGetter.LAB_END_DATE_STR:
                lab.setEndTime((LocalTime) param.getValue());
                break;
        }
    }

}
