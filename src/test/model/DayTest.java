package model;

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
        aDay.addObjective(anObjective);
        aDay.addObjective(anotherObjective);
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
        aDay.removeObjective(anObjective);
        assertEquals(aDay.listOfObjective.get(0), anotherObjective);
        aDay.removeObjective(anotherObjective);
        assertTrue(aDay.listOfObjective.isEmpty());
        //Test aDay.removeObjective(anotherObjective); and return exception no such objective
    }

}
