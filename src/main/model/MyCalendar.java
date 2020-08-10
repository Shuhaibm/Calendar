package model;


import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;

//The calendar, represents a single month
public class MyCalendar implements Saveable {
    public ArrayList<Day> calendarDays = new ArrayList<>();

    //EFFECTS: creates new Month, adds 30 days to calendarDays list
    public MyCalendar() {
        for (int i = 1; i < 31; i++) {
            calendarDays.add(new Day(i));
        }
    }

    /*
     * REQUIRES: calendar be a list of 30 days, with dates 1 to 30
     * EFFECTS: constructs a calendar with an arraylist of days
     * NOTE: this constructor is to be used only when constructing
     * an account from data stored in file
     */
    public MyCalendar(ArrayList<Day> calendarDays) {
        this.calendarDays = calendarDays;
    }


    // EFFECTS: records calendar to data
    @Override
    public void save(PrintWriter printWriter) {
        for (Day day: calendarDays) {
            printWriter.print(day.date);
            printWriter.print(Reader.DELIMITER);
            for (Objective objective: day.listOfObjective) {
                printWriter.print(objective.note);
                printWriter.print(Reader.DELIMITER);
                printWriter.print(objective.completeStatus);
                printWriter.print(Reader.DELIMITER);
            }
            printWriter.print(Reader.DAYDELIMITER);
        }
    }

}

