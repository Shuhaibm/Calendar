package model;

import exceptions.TooManyObjectivesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {
    Day aDay;
    Objective anObjective;
    Objective anotherObjective;

    @BeforeEach
    public void setup() {
        aDay = new Day(1);
        anObjective = new Objective("Finish homework");
        anotherObjective = new Objective("Finish workout");
        try {
            aDay.addObjective(anObjective);
        } catch (TooManyObjectivesException e) {
            e.printStackTrace();
        }
        try {
            aDay.addObjective(anotherObjective);
        } catch (TooManyObjectivesException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDay() {
        assertEquals(aDay.date, 1);
    }

    @Test
    public void testAddObjective() {
        assertEquals(aDay.listOfObjective.get(0), anObjective);
        assertEquals(aDay.listOfObjective.get(1), anotherObjective);
    }

    @Test
    public void testRemoveObjective(){
        aDay.removeObjective(1);
        assertEquals(aDay.listOfObjective.get(0), anotherObjective);
        aDay.removeObjective(0);
        assertTrue(aDay.listOfObjective.isEmpty());
        //Test aDay.removeObjective(anotherObjective); and return exception no such objective
    }

    @Test
    public void testGetDate() {
        assertEquals(aDay.getDate(), 1);
    }

    @Test
    public void testGetListOfObjective() {
        assertEquals(aDay.getListOfObjective(), aDay.listOfObjective);
    }
}
