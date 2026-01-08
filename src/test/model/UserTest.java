package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user1;
    Journal testJournal1;
    HabitTracker testHabitTracker1;
    VisionTracker testVisionTracker1;
    AchievementTracker testAchievementTracker1;

    User user2;
    Journal testJournal2;
    HabitTracker testHabitTracker2;
    VisionTracker testVisionTracker2;
    AchievementTracker testAchievementTracker2;

    @BeforeEach
    public void setup() {
        user1 = new User("R");
        testJournal1 = user1.getJournal();
        testHabitTracker1 = user1.getHabitTracker();
        testAchievementTracker1 = user1.getAchievementTracker();
        testVisionTracker1 = user1.getVisionTracker();

        user2 = new User("S");
        testJournal2 = user2.getJournal();
        testHabitTracker2 = user2.getHabitTracker();
        testAchievementTracker2 = user2.getAchievementTracker();
        testVisionTracker2 = user2.getVisionTracker();

        testJournal2.addNewEntry("I am happy.");
        testJournal2.addNewEntry("I want ice cream.");
        testHabitTracker2.addHabit("Running");
        testHabitTracker2.addHabit("Jumping");
        testHabitTracker2.addHabit("Coding");
        testVisionTracker2.newVision("Test" , "Pass" , "In first run");
        testAchievementTracker2.addAchievement("Ran 1km");
        testAchievementTracker2.addAchievement("Ran 2km");
    }

    @Test
    public void testGetJournal() {
        assertEquals(0 , testJournal1.returnEntries().size());

        assertEquals(2 , testJournal2.returnEntries().size());
        assertTrue(testJournal2.returnEntries().contains("I am happy."));
        assertTrue(testJournal2.returnEntries().contains("I want ice cream."));
    }

    @Test
    public void testGetHabitTracker() {
        assertTrue(testHabitTracker1.getHabits().isEmpty());

        assertEquals(3, testHabitTracker2.numberOfHabits());
        assertTrue(testHabitTracker2.getHabits().contains("Running"));
        assertTrue(testHabitTracker2.getHabits().contains("Jumping"));
        assertTrue(testHabitTracker2.getHabits().contains("Coding"));
    }

    @Test
    public void testGetVisionTracker() {
        assertTrue("".equalsIgnoreCase(testVisionTracker1.getVisionStatement()));
        assertTrue("".equalsIgnoreCase(testVisionTracker1.getDescription()));
        assertTrue("".equalsIgnoreCase(testVisionTracker1.getDeadline()));

        assertEquals("Test" , testVisionTracker2.getVisionStatement());
        assertEquals("Pass" , testVisionTracker2.getDescription());
        assertEquals("In first run" , testVisionTracker2.getDeadline());
    }

    @Test
    public void testGetName() {
        assertEquals("R" , user1.getName());
        assertEquals("S" , user2.getName());
    }

    @Test
    public void testGetAchievementTracker() {
        assertEquals(0 , testAchievementTracker1.returnAchievementCount());

        assertEquals(2 , testAchievementTracker2.returnAchievementCount());
        assertTrue(testAchievementTracker2.returnAchievements().contains("Ran 1km"));
        assertTrue(testAchievementTracker2.returnAchievements().contains("Ran 2km"));
    }
}
