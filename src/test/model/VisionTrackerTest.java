package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VisionTrackerTest {
    private VisionTracker testVisionTrackerEmpty;
    private VisionTracker testVisionTrackerNotEmpty;

    @BeforeEach
    public void setup() {
        testVisionTrackerEmpty = new VisionTracker();

        testVisionTrackerNotEmpty = new VisionTracker();
        String testVision = "I want to complete this project";
        String testDescription = "My CPSC 210 project is to be completed";
        String testDeadline = "By 26th Feb 2023";
        testVisionTrackerNotEmpty.newVision(testVision, testDescription, testDeadline);
    }

    @Test
    public void testConstructor() {
        assertTrue("".equalsIgnoreCase(testVisionTrackerEmpty.getVisionStatement()));
        assertTrue("".equalsIgnoreCase(testVisionTrackerEmpty.getDescription()));
        assertTrue("".equalsIgnoreCase(testVisionTrackerEmpty.getDeadline()));
    }

    @Test
    public void testGetVisionStatement() {
        assertTrue("".equalsIgnoreCase(testVisionTrackerEmpty.getVisionStatement()));
        assertEquals("I want to complete this project",
                testVisionTrackerNotEmpty.getVisionStatement());
    }

    @Test
    public void testGetDescription() {
        assertTrue("".equalsIgnoreCase(testVisionTrackerEmpty.getDescription()));
        assertEquals("My CPSC 210 project is to be completed",
                testVisionTrackerNotEmpty.getDescription());
    }

    @Test
    public void testGetDeadline() {
        assertTrue("".equalsIgnoreCase(testVisionTrackerEmpty.getDeadline()));
        assertEquals("By 26th Feb 2023",
                testVisionTrackerNotEmpty.getDeadline());
    }

    @Test
    public void testClearVision() {
        testVisionTrackerNotEmpty.clearVision();
        assertTrue("".equalsIgnoreCase(testVisionTrackerNotEmpty.getVisionStatement()));
        assertTrue("".equalsIgnoreCase(testVisionTrackerNotEmpty.getDescription()));
        assertTrue("".equalsIgnoreCase(testVisionTrackerNotEmpty.getDeadline()));
    }

    @Test
    public void testUpdateDescription() {
        assertFalse(testVisionTrackerEmpty.updateDescription("I want to be fit"));
        assertTrue("".equalsIgnoreCase(testVisionTrackerEmpty.getDescription()));

        assertEquals("My CPSC 210 project is to be completed",
                testVisionTrackerNotEmpty.getDescription());
        assertTrue(testVisionTrackerNotEmpty.updateDescription("My MATH 101 project is due"));
        assertEquals("My MATH 101 project is due",
                testVisionTrackerNotEmpty.getDescription());

    }

    @Test
    public void testUpdateDeadline() {
        assertFalse(testVisionTrackerEmpty.updateDeadline("By end of Term 2"));
        assertTrue("".equalsIgnoreCase(testVisionTrackerEmpty.getDeadline()));

        assertEquals("By 26th Feb 2023",
                testVisionTrackerNotEmpty.getDeadline());
        assertTrue(testVisionTrackerNotEmpty.updateDeadline("By 24th Feb 2023"));
        assertEquals("By 24th Feb 2023",
                testVisionTrackerNotEmpty.getDeadline());
    }

    @Test
    public void testNewVision() {
        String testNewVisionStatement = "I want to be shredded";
        String testNewDescription = "I want to be <12% body fat";
        String testNewDeadline = "By End Of Term 2";

        testVisionTrackerEmpty.newVision(testNewVisionStatement,
                testNewDescription,
                testNewDeadline);

        assertEquals(testNewVisionStatement,
                testVisionTrackerEmpty.getVisionStatement());
        assertEquals(testNewDescription,
                testVisionTrackerEmpty.getDescription());
        assertEquals(testNewDeadline,
                testVisionTrackerEmpty.getDeadline());

        testVisionTrackerNotEmpty.newVision(testNewVisionStatement,
                testNewDescription,
                testNewDeadline);

        assertEquals(testNewVisionStatement,
                testVisionTrackerNotEmpty.getVisionStatement());
        assertEquals(testNewDescription,
                testVisionTrackerNotEmpty.getDescription());
        assertEquals(testNewDeadline,
                testVisionTrackerNotEmpty.getDeadline());
    }
}
