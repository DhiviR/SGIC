package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import Utility.Utility;

public class TestCases {
	Utility utility;
	
	@BeforeEach
	void setUp() {
		 utility = new Utility();
    }

	@Test
	public void testStringToDate() throws ParseException {
		assertEquals(12/8/2022, utility.stringToDate("12/8/2022"));
	}

	@Test
	public void testIsAlphaNumeric() {
		assertTrue(utility.isAlphaNumeric("word"));
	}

	@Test
	public void testIsNullorEmpty() {
		assertTrue(utility.isNullOrEmpty(""));
	}

	@Test
	public void testRemoveLeadingZeros() {
		assertEquals("405", utility.removeLeadingZeros("000405"));
	}

}
