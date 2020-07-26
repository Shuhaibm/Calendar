package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarTest {
    MyCalendar aCalendar;

    @BeforeEach
    public void setup() {
        aCalendar = new MyCalendar();
    }

    @Test
    public void testMyCalendar() {
        assertEquals(aCalendar.calendarDays.size(), 30);
        assertEquals(aCalendar.calendarDays.get(0).date, 1);
        assertEquals(aCalendar.calendarDays.get(29).date, 30);

    }
}