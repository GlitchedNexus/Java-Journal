package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Users users = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderNoUsers() {
        JsonReader reader = new JsonReader("./data/testReaderEmpty.json");
        try {
            Users users = reader.read();
            assertEquals(0 , users.getUsernames().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderWithUsers() {
        JsonReader reader = new JsonReader("./data/testReaderNotEmpty.json");
        try {
            Users users = reader.read();

            User testUserA = users.getUser("A");

            assertEquals("Raghav" , testUserA.getName());

            assertTrue(users.checkValidUser("A" , "456"));

            assertEquals(2 , testUserA.getAchievementTracker().returnAchievementCount());
            assertTrue(testUserA.getAchievementTracker().returnAchievements().contains("Ran 4km"));
            assertTrue(testUserA.getAchievementTracker().returnAchievements().contains("Ran 2km"));

            assertEquals(1 , testUserA.getHabitTracker().getHabits().size());
            assertTrue(testUserA.getHabitTracker().getHabits().contains("Coding"));

            assertEquals("X" , testUserA.getVisionTracker().getVisionStatement());
            assertEquals("Y" , testUserA.getVisionTracker().getDescription());
            assertEquals("Z" , testUserA.getVisionTracker().getDeadline());

            assertEquals(1 , testUserA.getJournal().returnEntries().size());
            assertTrue(testUserA.getJournal().returnEntries().contains("I am happy"));

            User testUserB = users.getUser("B");

            assertTrue(users.checkValidUser("B" , "567"));

            assertEquals("Samantha" , testUserB.getName());

            assertEquals(1 , testUserB.getAchievementTracker().returnAchievementCount());
            assertTrue(testUserB.getAchievementTracker().returnAchievements().contains("Ran 1km"));

            assertEquals(1 , testUserB.getHabitTracker().getHabits().size());
            assertTrue(testUserB.getHabitTracker().getHabits().contains("Jumping"));

            assertEquals("P" , testUserB.getVisionTracker().getVisionStatement());
            assertEquals("Q" , testUserB.getVisionTracker().getDescription());
            assertEquals("R" , testUserB.getVisionTracker().getDeadline());

            assertEquals(1 , testUserB.getJournal().returnEntries().size());
            assertTrue(testUserB.getJournal().returnEntries().contains("I am sad"));


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
