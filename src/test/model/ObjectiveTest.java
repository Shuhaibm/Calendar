package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectiveTest {

    Objective anObjective;

    @BeforeEach
    public void setup(){
        anObjective = new Objective("Complete 210 assignment");
    }

    @Test
    public void testObjective() {
        assertEquals("Complete 210 assignment", anObjective.note);
        assertFalse(anObjective.completeStatus);
        //Try renaming and return exception - if I end up having my set Note method

    }

    @Test
    public void testMarkComplete() {
        anObjective.markComplete();
        assertTrue(anObjective.completeStatus);
        // DO anObjective.markComplete(); again and return false because status is not already false
    }


}
