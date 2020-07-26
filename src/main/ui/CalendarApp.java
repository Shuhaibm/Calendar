package ui;

import model.Day;
import model.MyCalendar;
import model.Objective;

import java.util.*;


// Calendar Application
public class CalendarApp {
    private Scanner input;
    private MyCalendar calendar = new MyCalendar();

    //EFFECTS: run the calendar application
    public CalendarApp() {
        runCalendar();
    }

    //MODIFIES: this
    //EFFECTS: processes the user input
    private void runCalendar() {
        boolean runApp = true;
        input = new Scanner(System.in);
        String command;

        while (runApp) {
            displayMenu();
            command = input.next();

            if (command.equals("q")) {
                runApp = false;
            } else {
                processCommand(command);
            }
        }
    }

    //EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect one of the following:");
        System.out.println("\tv -> View calendar");
        System.out.println("\ta -> Add an objective");
        System.out.println("\tr -> Remove an objective");
        System.out.println("\tc -> Mark an objective as complete");
        System.out.println("\t? -> Check complete status");
        System.out.println("\tq -> quit");

    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("v")) {
            showMyCalendar();
        } else if (command.equals("a")) {
            doAddObjective();
        } else if (command.equals("r")) {
            doRemoveObjective();
        } else if (command.equals("c")) {
            doMarkComplete();
        } else if (command.equals("?")) {
            doCheckComplete();
        }

    }

    //EFFECTS: Shows the calendar (everyday + objectives
    private void showMyCalendar() {
        for (Day day: calendar.calendarDays) {
            System.out.println("Date: " + day.date);
            for (Objective objective: day.listOfObjective) {
                System.out.println("\t" + objective);
            }
        }
    }

    private void doAddObjective() {

    }

    private void doRemoveObjective() {}

    private void doMarkComplete() {}

    private void doCheckComplete() {}

}
