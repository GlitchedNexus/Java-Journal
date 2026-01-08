package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Unit Tests For HabitTracker Class
public class HabitTrackerTest {
    private HabitTracker testHabitTracker;

    @BeforeEach
    public void setup() {
        testHabitTracker = new HabitTracker();
    }

    @Test
    public void testConstructor() {
        assertEquals(0 , testHabitTracker.numberOfHabits());
    }

    @Test
    public void testAddHabits() {
        testHabitTracker.addHabit("Running");
        assertEquals(1 , testHabitTracker.numberOfHabits());
        assertTrue(testHabitTracker.getHabits().contains("Running"));
        testHabitTracker.addHabit("Jumping");
        assertEquals(2 , testHabitTracker.numberOfHabits());
        assertTrue(testHabitTracker.getHabits().contains("Jumping"));
        testHabitTracker.addHabit("Running");
        assertEquals(2 , testHabitTracker.numberOfHabits());
    }

    @Test
    public void testRemoveHabit() {
        testHabitTracker.addHabit("Running");
        testHabitTracker.addHabit("Jumping");
        assertEquals(2 , testHabitTracker.numberOfHabits());


        assertFalse(testHabitTracker.removeHabit("Singing"));

        assertTrue(testHabitTracker.removeHabit("Running"));
        assertEquals(1 , testHabitTracker.numberOfHabits());
        assertFalse(testHabitTracker.getHabits().contains("Running"));

        assertTrue(testHabitTracker.removeHabit("Jumping"));
        assertEquals(0 , testHabitTracker.numberOfHabits());
        assertFalse(testHabitTracker.getHabits().contains("Jumping"));
    }

    @Test
    public void testReturnHabits() {
        ArrayList<String> testArrayList = new ArrayList<String>();

        assertTrue(testArrayList.equals(testHabitTracker.getHabits()));

        testArrayList.add("Running");
        testArrayList.add("Jumping");
        testHabitTracker.addHabit("Running");
        testHabitTracker.addHabit("Jumping");
        assertTrue(testArrayList.equals(testHabitTracker.getHabits()));
        assertTrue(testHabitTracker.getHabits().contains("Running"));
        assertTrue(testHabitTracker.getHabits().contains("Jumping"));
    }

    @Test
    public void testClearHabits() {
        testHabitTracker.addHabit("Running");
        testHabitTracker.addHabit("Jumping");
        assertEquals(2 , testHabitTracker.numberOfHabits());

        testHabitTracker.clearHabits();
        assertEquals(0 , testHabitTracker.numberOfHabits());
        assertFalse(testHabitTracker.getHabits().contains("Running"));
        assertFalse(testHabitTracker.getHabits().contains("Jumping"));

    }

    @Test
    public void testNumberOfHabits() {
        assertEquals(0 , testHabitTracker.numberOfHabits());
        testHabitTracker.addHabit("Running");
        testHabitTracker.addHabit("Jumping");
        assertEquals(2 , testHabitTracker.numberOfHabits());
    }
}
