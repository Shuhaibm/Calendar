package ui;

import model.Day;
import model.MyCalendar;
import model.Objective;

import java.util.*;


// Calendar Application
public class CalendarApp {
    private Scanner input;
    private MyCalendar calendar = new MyCalendar();
    private ArrayList dates = new ArrayList();


    //EFFECTS: runs the calendar application
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
        int dateIndex = selectDate() - 1;
        System.out.println("Please enter the objective you want to add");
        String objectiveNote = input.next();
        Objective objective = new Objective(objectiveNote);
        calendar.calendarDays.get(dateIndex).addObjective(objective);
    }

    //MODIFIES: calendar
    //EFFECTS: removes specified objective from specified date
    private void doRemoveObjective() {
        int dateIndex = selectDate() - 1;
        System.out.println("Please enter the position of the objective you want to remove (1, 2, 3, 4, 5)");
        String objectivePosition = input.next();
        int objectiveIndex = Integer.parseInt(objectivePosition) - 1;
        calendar.calendarDays.get(dateIndex).removeObjective(objectiveIndex);
    }

    //MODIFIES: calendar
    //EFFECTS: Marks the specified objective complete
    private void doMarkComplete() {
        int dateIndex = selectDate() - 1;
        System.out.println("Please enter the position of the objective you have completed (1, 2, 3, 4, 5)");
        String objectivePosition = input.next();
        int objectiveIndex = Integer.parseInt(objectivePosition) - 1;
        calendar.calendarDays.get(dateIndex).listOfObjective.get(objectiveIndex).markComplete();
    }

    //EFFECTS: gets the user to select a date and returns it
    private int selectDate() {
        for (int i = 1; i < 31;i++) {
            dates.add(Integer.toString(i));
        }
        String selected = "0";
        while (!(dates.contains(selected))) {
            System.out.println("Please enter a valid date");
            selected = input.next();
        }
        return Integer.parseInt(selected);
    }



}
