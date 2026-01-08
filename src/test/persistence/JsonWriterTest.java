package persistence;

import model.User;
import model.Users;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Users users = new Users();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterNoUsers() {
        try {
            Users users = new Users();
            JsonWriter writer = new JsonWriter("./data/testWriterEmpty.json");
            writer.open();
            writer.write(users);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmpty.json");
            users = reader.read();
            assertEquals(0, users.getUsernames().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterNotEmpty() {
        try {
            Users users = new Users();

            users.addNewUser("R", "123", "Raghav");
            users.addNewUser("S", "234", "Samantha");

            User testUserR = users.getUser("R");
            testUserR.getJournal().addNewEntry("I am happy");
            testUserR.getHabitTracker().addHabit("Coding");
            testUserR.getAchievementTracker().addAchievement("Ran 4km");
            testUserR.getVisionTracker().newVision("A" , "B" , "C");

            User testUserS = users.getUser("S");
            testUserS.getJournal().addNewEntry("I am sad");
            testUserS.getHabitTracker().addHabit("Jumping");
            testUserS.getAchievementTracker().addAchievement("Ran 1km");
            testUserS.getVisionTracker().newVision("C" , "D" , "F");

            JsonWriter writer = new JsonWriter("./data/testWriterNotEmpty.json");
            writer.open();
            writer.write(users);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterNotEmpty.json");
            users = reader.read();

            User testUserRNew = users.getUser("R");

            assertEquals("Raghav" , testUserRNew.getName());

            assertTrue(users.checkValidUser("R" , "123"));

            assertEquals(1 , testUserRNew.getAchievementTracker().returnAchievementCount());
            assertTrue(testUserRNew.getAchievementTracker().returnAchievements().contains("Ran 4km"));

            assertEquals(1 , testUserRNew.getHabitTracker().getHabits().size());
            assertTrue(testUserRNew.getHabitTracker().getHabits().contains("Coding"));

            assertEquals("A" , testUserRNew.getVisionTracker().getVisionStatement());
            assertEquals("B" , testUserRNew.getVisionTracker().getDescription());
            assertEquals("C" , testUserRNew.getVisionTracker().getDeadline());

            assertEquals(1 , testUserRNew.getJournal().returnEntries().size());
            assertTrue(testUserRNew.getJournal().returnEntries().contains("I am happy"));

            User testUserSNew = users.getUser("S");

            assertTrue(users.checkValidUser("S" , "234"));

            assertEquals("Samantha" , testUserSNew.getName());

            assertEquals(1 , testUserSNew.getAchievementTracker().returnAchievementCount());
            assertTrue(testUserSNew.getAchievementTracker().returnAchievements().contains("Ran 1km"));

            assertEquals(1 , testUserSNew.getHabitTracker().getHabits().size());
            assertTrue(testUserSNew.getHabitTracker().getHabits().contains("Jumping"));

            assertEquals("C" , testUserSNew.getVisionTracker().getVisionStatement());
            assertEquals("D" , testUserSNew.getVisionTracker().getDescription());
            assertEquals("F" , testUserSNew.getVisionTracker().getDeadline());

            assertEquals(1 , testUserSNew.getJournal().returnEntries().size());
            assertTrue(testUserSNew.getJournal().returnEntries().contains("I am sad"));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
