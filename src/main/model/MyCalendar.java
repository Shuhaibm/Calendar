package model;


import java.util.ArrayList;

//The calendar, represents a single month
public class MyCalendar {
    public ArrayList<Day> calendarDays = new ArrayList<>();

    //EFFECTS: creates new Month, adds 30 days to calendarDays list
    public MyCalendar() {
        for (int i = 1; i < 31;i++) {
            calendarDays.add(new Day(i));
        }
    }

    //CODE FOR CATCHING IT, BUT DO NOT NEED IT YET
    //EFFECTS: creates new Month, adds 30 days to calendarDays list
    //public MyCalendar() {
    //   for (int i = 1; i < 31;i++) {
    //        try {
    //            calendarDays.add(new Day(i));
    //        } catch (InvalidDateException e) {
    //            //Too many days!
    //        }
    //    }
    //}

}
