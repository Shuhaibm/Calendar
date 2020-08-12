package persistence;

import exceptions.TooManyObjectivesException;
import model.MyCalendar;
import model.Objective;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Tests Writer class
public class WriterTest {

    private static final String TEST_FILE = "./data/testCalendarFile1.txt";
    private Writer testWriter;
    private MyCalendar calendar;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        calendar = new MyCalendar();
        try {
            calendar.calendarDays.get(0).addObjective(new Objective("asdf"));
        } catch (TooManyObjectivesException e) {
            fail();
        }
        testWriter = new Writer(new File(TEST_FILE));

    }

    @Test
    void testWriteAccounts() {
        // save calendars to file
        testWriter.write(calendar);

        testWriter.close();

        // now read them back in and verify that the calendars are as expected
        try {
            List<MyCalendar> calendars = Reader.readCalendars(new File(TEST_FILE));
            MyCalendar calendar = calendars.get(0);
            assertEquals(30, calendar.calendarDays.size());
            assertEquals(0, calendar.calendarDays.get(1).listOfObjective.size());
            assertEquals("asdf", calendar.calendarDays.get(0).listOfObjective.get(0).note);
            assertEquals(false, calendar.calendarDays.get(0).listOfObjective.get(0).completeStatus);


        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}
