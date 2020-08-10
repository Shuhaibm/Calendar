package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Tests Day class
public class DayTest {
    Day myDay;
    Objective anObjective;
    Objective anotherObjective;

    @BeforeEach
    public void setup() {
        myDay = new Day(1);
        anObjective = new Objective("Finish homework");
        anotherObjective = new Objective("Finish workout");
        myDay.addObjective(anObjective);
        myDay.addObjective(anotherObjective);
    }

    @Test
    public void testDay() {
        assertEquals(myDay.date, 1);
    }

    @Test
    public void testAddObjective() {
        assertEquals(myDay.listOfObjective.get(0), anObjective);
        assertEquals(myDay.listOfObjective.get(1), anotherObjective);
    }

    @Test
    public void testRemoveObjective() {
        myDay.removeObjective(0);
        assertEquals(myDay.listOfObjective.get(0), anotherObjective);
        myDay.removeObjective(0);
        assertTrue(myDay.listOfObjective.isEmpty());
        //Test aDay.removeObjective(anotherObjective); and return exception no such objective
    }

    @Test
    public void testGetDate() {
        assertEquals(myDay.getDate(), 1);
    }

    @Test
    public void testGetListOfObjective() {
        assertEquals(myDay.getListOfObjective(), myDay.listOfObjective);
    }
}
