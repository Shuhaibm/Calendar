package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarTest {
    MyCalendar myCalendar;

    @BeforeEach
    public void setup() {
        myCalendar = new MyCalendar();
    }

    @Test
    public void testMyCalendar() {
        assertEquals(myCalendar.calendarDays.size(), 30);
        assertEquals(myCalendar.calendarDays.get(0).date, 1);
        assertEquals(myCalendar.calendarDays.get(29).date, 30);

    }
}