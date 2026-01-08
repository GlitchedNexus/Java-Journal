package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JournalTest {
    private Journal testJournalEmpty;
    private Journal testJournalNotEmpty;

    @BeforeEach
    public void setup() {
        testJournalEmpty = new Journal();

        testJournalNotEmpty = new Journal();
        testJournalNotEmpty.addNewEntry("I am happy");
        testJournalNotEmpty.addNewEntry("I want ice cream");
    }

    @Test
    public void testConstructor() {
        assertTrue(testJournalEmpty.returnEntries().isEmpty());
    }

    @Test
    public void testAddNewEntry() {
        assertEquals(0 , testJournalEmpty.returnEntries().size());
        testJournalEmpty.addNewEntry("I am happy");
        assertEquals(1 , testJournalEmpty.returnEntries().size());
        assertTrue(testJournalEmpty.returnEntries().contains("I am happy"));
        testJournalEmpty.addNewEntry("I want ice cream");
        assertEquals(2 , testJournalEmpty.returnEntries().size());
        assertTrue(testJournalEmpty.returnEntries().contains("I want ice cream"));
    }

    @Test
    public void testReturnEntries() {
        assertTrue(testJournalEmpty.returnEntries().isEmpty());
        assertEquals(0 , testJournalEmpty.returnEntries().size());

        assertEquals(2 , testJournalNotEmpty.returnEntries().size());
        assertTrue(testJournalNotEmpty.returnEntries().contains("I am happy"));
        assertTrue(testJournalNotEmpty.returnEntries().contains("I want ice cream"));
    }

    @Test
    public void testRemoveLastEntry() {
        assertEquals(2 , testJournalNotEmpty.returnEntries().size());
        assertTrue(testJournalNotEmpty.returnEntries().contains("I am happy"));
        assertTrue(testJournalNotEmpty.returnEntries().contains("I want ice cream"));

        assertEquals("I want ice cream" , testJournalNotEmpty.removeLastEntry());
        assertEquals(1 , testJournalNotEmpty.returnEntries().size());
        assertEquals("I am happy" , testJournalNotEmpty.removeLastEntry());
        assertEquals(0 , testJournalNotEmpty.returnEntries().size());
        assertEquals("" , testJournalNotEmpty.removeLastEntry());
        assertEquals(0 , testJournalNotEmpty.returnEntries().size());
    }

    @Test
    public void testClearAllEntries() {
        assertEquals(2 , testJournalNotEmpty.returnEntries().size());
        testJournalNotEmpty.clearAllEntries();
        assertEquals(0 , testJournalNotEmpty.returnEntries().size());

        assertEquals(0 , testJournalEmpty.returnEntries().size());
        testJournalEmpty.clearAllEntries();
        assertEquals(0 , testJournalEmpty.returnEntries().size());
    }
}
