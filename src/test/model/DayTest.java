package model;

import exceptions.NoSuchObjectiveException;
import exceptions.TooManyObjectivesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Tests Day class
public class DayTest {
    Day myDay;
    Day anotherDay;
    Objective anObjective;
    Objective anotherObjective;

    @BeforeEach
    public void setup() {
        myDay = new Day(1);
        anotherDay = new Day(2);
        anObjective = new Objective("Finish homework");
        anotherObjective = new Objective("Finish workout");
    }

    @Test
    public void testDay() {
        assertEquals(myDay.date, 1);
    }

    @Test
    public void testAddObjective() {
        try {
            myDay.addObjective(anObjective);
        } catch (TooManyObjectivesException e) {
            fail();
        }
        try {
            myDay.addObjective(anotherObjective);
        } catch (TooManyObjectivesException e) {
            fail();
        }
        assertEquals(myDay.listOfObjective.get(0), anObjective);
        assertEquals(myDay.listOfObjective.get(1), anotherObjective);
    }

    @Test
    public void testRemoveObjective() {
        try {
            myDay.addObjective(anObjective);
        } catch (TooManyObjectivesException e) {
            fail();
        }
        try {
            myDay.addObjective(anotherObjective);
        } catch (TooManyObjectivesException e) {
            fail();
        }
        try {
            myDay.removeObjective(0);
        } catch (NoSuchObjectiveException e) {
            fail();
        }
        assertEquals(myDay.listOfObjective.get(0), anotherObjective);

        try {
            myDay.removeObjective(0);
        } catch (NoSuchObjectiveException e) {
            fail();
        }
        assertTrue(myDay.listOfObjective.isEmpty());


    }

    @Test
    public void testGetDate() {
        assertEquals(myDay.getDate(), 1);
    }

    @Test
    public void testGetListOfObjective() {
        assertEquals(myDay.getListOfObjective(), myDay.listOfObjective);
    }

    @Test
    public void testTooManyObjectivesException() {
        for (int x = 0; x < Day.MAXOBJECTIVES; x++) {
            try {
                anotherDay.addObjective(anObjective);
            } catch (TooManyObjectivesException e) {
                fail();
            }
        }

        try {
            anotherDay.addObjective(anObjective);
        } catch (TooManyObjectivesException e) {
            //Do nothing, test passes
        }


    }

    @Test
    public void testNoSuchObjectiveException() {
        try {
            myDay.removeObjective(0);
        } catch (NoSuchObjectiveException e) {
            //Do nothing, test passes
        }
    }

}
