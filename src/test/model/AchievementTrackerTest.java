package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AchievementTrackerTest {
    private AchievementTracker testAchievementTrackerEmpty;
    private AchievementTracker testAchievementTrackerNotEmpty;

    @BeforeEach
    public void setup() {
        testAchievementTrackerNotEmpty = new AchievementTracker();
        testAchievementTrackerNotEmpty.addAchievement("Ran 1km");
        testAchievementTrackerNotEmpty.addAchievement("Ran 2km");
        testAchievementTrackerNotEmpty.addAchievement("Ran 3km");
        testAchievementTrackerNotEmpty.addAchievement("Ran 4km");
        testAchievementTrackerNotEmpty.addAchievement("Ran 5km");
        testAchievementTrackerNotEmpty.addAchievement("Ran 6km");
        testAchievementTrackerNotEmpty.addAchievement("Ran 7km");
        testAchievementTrackerNotEmpty.addAchievement("Ran 8km");

        testAchievementTrackerEmpty = new AchievementTracker();

    }

    @Test
    public void testConstructor() {
        assertEquals(0 , testAchievementTrackerEmpty.returnAchievementCount());
        assertTrue(testAchievementTrackerEmpty.returnAchievements().isEmpty());
    }

    @Test
    public void testAddAchievement() {
        testAchievementTrackerEmpty.addAchievement("Ran 1km");
        testAchievementTrackerEmpty.addAchievement("Ran 2km");

        assertEquals(2 , testAchievementTrackerEmpty.returnAchievementCount());
        assertTrue(testAchievementTrackerEmpty.returnAchievements().contains("Ran 1km"));
        assertTrue(testAchievementTrackerEmpty.returnAchievements().contains("Ran 2km"));
    }

    @Test
    public void testClearAchievement() {
        assertEquals(8 , testAchievementTrackerNotEmpty.returnAchievementCount());
        testAchievementTrackerNotEmpty.clearAchievements();
        assertEquals(0 , testAchievementTrackerNotEmpty.returnAchievementCount());
    }

    @Test
    public void testReturnAchievementCount() {
        assertEquals(8 , testAchievementTrackerNotEmpty.returnAchievementCount());
        assertEquals(0 , testAchievementTrackerEmpty.returnAchievementCount());
    }

    @Test
    public void testReturnAchievements() {
        ArrayList<String> testArrayList = new ArrayList<>();

        assertTrue(testArrayList.equals(testAchievementTrackerEmpty.returnAchievements()));

        testArrayList.add("Ran 1km");
        testArrayList.add("Ran 2km");
        testArrayList.add("Ran 3km");
        testArrayList.add("Ran 4km");
        testArrayList.add("Ran 5km");
        testArrayList.add("Ran 6km");
        testArrayList.add("Ran 7km");
        testArrayList.add("Ran 8km");

        assertTrue(testArrayList.equals(testAchievementTrackerNotEmpty.returnAchievements()));

    }
}
