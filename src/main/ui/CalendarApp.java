package ui;

import exceptions.TooManyObjectivesException;
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
            System.out.println("Day " + day.date);
            for (Objective objective: day.listOfObjective) {
                System.out.println("\t" + objective.note);
            }
        }
    }

    //MODIFIES: calendar
    //EFFECTS: adds specified objective to the specified date
    private void doAddObjective() {
        System.out.println("Please enter a valid date for the objective");
        int dateIndex = selectDate() - 1;
        System.out.println("Please enter the objective you want to add");
        String objectiveNote = input.next();
        Objective objective = new Objective(objectiveNote);
        try {
            calendar.calendarDays.get(dateIndex).addObjective(objective);
        } catch (TooManyObjectivesException e) {
            e.printStackTrace();
            System.out.println("You have already reached the maximum objectives for this day");
        }
    }

    //MODIFIES: calendar
    //EFFECTS: removes specified objective from specified date
    private void doRemoveObjective() {
        System.out.println("Please enter the date of the objective");
        int dateIndex = selectDate() - 1;
        System.out.println("Please enter the position of the objective you want to remove (1, 2, 3, 4, 5)");
        String objectivePosition = input.next();
        int objectiveIndex = Integer.parseInt(objectivePosition) - 1;
        calendar.calendarDays.get(dateIndex).removeObjective(objectiveIndex);
    }

    //EFFECTS: gets the user to select a date and returns it
    private int selectDate() {
        String selected = "0";
        while (Integer.parseInt(selected) < 1 || Integer.parseInt(selected) > 30) {
            selected = input.next();
        }
        return Integer.parseInt(selected);
    }


    private void doMarkComplete() {}

    private void doCheckComplete() {}

}
