package edu.kpi.labtime;

import edu.kpi.labtime.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Application.run(args);
    }

    private static void run(String[] args) {
        Application app = new Application();
        //parse command line arguments
        app.run();
    }

    private void run() {
        Controller controller = new Controller();
        //setup controller
        controller.run();
    }
}
