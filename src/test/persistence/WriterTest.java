package persistence;

import model.MyCalendar;
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

public class WriterTest {

    private static final String TEST_FILE = "./data/testAccounts.txt";
    private Writer testWriter;
    private MyCalendar calendar;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        calendar = new MyCalendar();
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
            assertEquals(0, calendar.calendarDays.get(0).listOfObjective.size());


        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}
