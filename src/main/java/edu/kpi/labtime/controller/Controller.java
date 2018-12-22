package edu.kpi.labtime.controller;

import edu.kpi.labtime.constants.Constants;
import edu.kpi.labtime.exception.HelpException;
import edu.kpi.labtime.exception.LTException;
import edu.kpi.labtime.exception.ShutdownException;
import edu.kpi.labtime.exception.validation.ValidationException;
import edu.kpi.labtime.model.Param;
import edu.kpi.labtime.model.result.Result;
import edu.kpi.labtime.model.result.ResultString;
import edu.kpi.labtime.view.View;
import javafx.util.Pair;

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
        return new ResultString("NO BUSINESS LOGIC STILL");
    }

}
