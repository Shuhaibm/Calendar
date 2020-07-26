package model;

import java.util.ArrayList;


public class MyCalendar {
    public ArrayList<Day> calendarDays = new ArrayList<>();

    public MyCalendar() {
        for (int i = 1; i < 31;i++) {
            calendarDays.add(new Day(i));
        }
    }

}
