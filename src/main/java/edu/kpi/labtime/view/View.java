package edu.kpi.labtime.view;

import edu.kpi.labtime.model.Lab;
import edu.kpi.labtime.model.result.Result;

public class View {

    private static View INSTANCE = new View();

    public static View getInstance() {
        return INSTANCE;
    }

    private View() {}


    private String LINE     = "\n-----------------------------------\n";
    private String ERROR    = "-------------- ERROR --------------\n";
    private String SUCCESS  = "------------- SUCCESS -------------\n";

    public void display(String info) {

        System.out.println(LINE + info + LINE);

    }

    public void display(Lab lab) {
        display(lab.toString());
    }

    public void displayError(String error) {
        System.err.println(LINE + ERROR + LINE + error + LINE);
    }

    public void display(Result result) {
        System.out.println(LINE + SUCCESS + LINE + result.getMessage() + LINE);
    }
}
