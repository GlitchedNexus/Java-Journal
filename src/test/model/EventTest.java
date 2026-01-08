package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


// Notice Of Reference:
// The following EventTest class is sourced from the example provided in the AlarmSystem Example Project
// for phase 3

/**
 * Unit tests for the Event class
 */
public class EventTest {
	private Event e;
	private Date d;
    private Event e2;
    private Date d2;
	
	//NOTE: these tests might fail if time at which line (2) below is executed
	//is different from time that line (1) is executed.  Lines (1) and (2) must
	//run in same millisecond for this test to make sense and pass.

	
	@BeforeEach
	public void runBefore() {
		e = new Event("Entry Added");   // (1)
		d = Calendar.getInstance().getTime();   // (2)
	}
	
	@Test
	public void testEvent() {
		assertEquals("Entry Added", e.getDescription());
		assertEquals(d, e.getDate());
	}

	@Test
	public void testToString() {
		assertEquals(d.toString() + "\n" + "Entry Added", e.toString());
	}

    @Test
    public void testEqualsNull() {
        assertFalse(e.equals(null));
    }

    @Test
    public void testEqualsDifferentClasses() {
        assertFalse(e.equals(2));
    }

    @Test
    public void testHashCode() {
        int testHashCode = 13 * e.getDate().hashCode() + e.getDescription().hashCode();
        assertEquals(testHashCode, e.hashCode());
    }
}
