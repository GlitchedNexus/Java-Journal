package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {
    private Users testUsersEmpty;
    private Users testUsersNotEmpty;

    @BeforeEach
    public void setup() {
        testUsersEmpty = new Users();

        testUsersNotEmpty = new Users();
        testUsersNotEmpty.addNewUser("Raghav" , "123" , "Raghav Awasthi");
        testUsersNotEmpty.addNewUser("Kai" , "234" , "Kai Wei");
        testUsersNotEmpty.addNewUser("Stanley" , "345" , "Stanley Yin");
        testUsersNotEmpty.addNewUser("Colin" , "456" , "Colin Law");
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testUsersEmpty.getUsernames().size());
    }

    @Test
    public void testAddNewUser() {
        testUsersEmpty.addNewUser("Raghav" , "123" , "Raghav Awasthi");
        assertEquals(1 , testUsersEmpty.getUsernames().size());

        assertFalse(testUsersNotEmpty.addNewUser("Raghav" , "13" , "R Awasthi"));
        assertEquals(4 , testUsersNotEmpty.getUsernames().size());
        assertTrue(testUsersNotEmpty.addNewUser("Nathan" , "567" , "Nathan Chan"));
        assertTrue(testUsersNotEmpty.getUsernames().contains("Nathan"));
        assertEquals(5 , testUsersNotEmpty.getUsernames().size());
    }

    @Test
    public void testRemoveUser() {
        assertFalse(testUsersEmpty.removeUser("Raghav"));
        assertEquals(0 , testUsersEmpty.getUsernames().size());
        assertFalse(testUsersNotEmpty.removeUser("Nathan"));
        assertEquals(4 , testUsersNotEmpty.getUsernames().size());

        assertTrue(testUsersNotEmpty.removeUser("Raghav"));
        assertFalse(testUsersNotEmpty.getUsernames().contains("Raghav"));
        assertEquals(3 , testUsersNotEmpty.getUsernames().size());
    }

    @Test
    public void testCheckValidUser() {
        assertFalse(testUsersEmpty.checkValidUser("Raghav" , "123"));

        assertTrue(testUsersNotEmpty.checkValidUser("Raghav" , "123"));
        assertTrue(testUsersNotEmpty.checkValidUser("Stanley" , "345"));
        assertFalse(testUsersNotEmpty.checkValidUser("Stanley" , "589"));
        assertFalse(testUsersNotEmpty.checkValidUser("Nathan" , "589"));
        assertFalse(testUsersNotEmpty.checkValidUser("Luna" , "589"));
    }

    @Test
    public void testGetUsernames() {
        assertTrue(testUsersEmpty.getUsernames().isEmpty());

        assertEquals(4, testUsersNotEmpty.getUsernames().size());
        assertTrue(testUsersNotEmpty.getUsernames().contains("Raghav"));
        assertTrue(testUsersNotEmpty.getUsernames().contains("Kai"));
        assertTrue(testUsersNotEmpty.getUsernames().contains("Stanley"));
        assertTrue(testUsersNotEmpty.getUsernames().contains("Colin"));
    }

    @Test
    public void testGetUser() {
        assertEquals("Raghav Awasthi" , testUsersNotEmpty.getUser("Raghav").getName());
        assertEquals("Colin Law" , testUsersNotEmpty.getUser("Colin").getName());
        assertEquals("Stanley Yin" , testUsersNotEmpty.getUser("Stanley").getName());
        assertEquals("Kai Wei" , testUsersNotEmpty.getUser("Kai").getName());
    }
}
