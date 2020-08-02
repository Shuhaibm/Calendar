package persistence;

import model.MyCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {

    @BeforeEach
    void setup() {
        Reader readerTest = new Reader();
    }

    @Test
    void testMakeCalendarsSampleFile() {
        try {
            List<MyCalendar> calendars = Reader.readCalendars(new File("./data/testCalendarFile1.txt"));
            MyCalendar calendar1 = calendars.get(0);
            assertEquals(30, calendar1.calendarDays.size());
            assertEquals("asdf", calendar1.calendarDays.get(0).listOfObjective.get(0).note);
            assertEquals(false, calendar1.calendarDays.get(0).listOfObjective.get(0).completeStatus);
            assertTrue(calendar1.calendarDays.get(1).listOfObjective.isEmpty());
            /* 
            MyCalendar calendar2 = calendars.get(1);
            assertEquals(30, calendar2.calendarDays.size());
            assertEquals("fdsa", calendar2.calendarDays.get(1).listOfObjective.get(0).note);
            assertEquals(true, calendar2.calendarDays.get(1).listOfObjective.get(0).completeStatus);
            assertTrue(calendar2.calendarDays.get(0).listOfObjective.isEmpty());
            */
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readCalendars(new File("./path/does/not/exist/testAccount.txt"));
        } catch (IOException e) {

        }
    }
}
