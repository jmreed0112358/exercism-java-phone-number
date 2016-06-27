package phonenumber;
import org.junit.Test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

public class PhoneNumberTest {

	@Test
	public void test_EmptyString_ReturnsInvalidNumber() {
		final String expectedNumber = "0000000000";
		final String actualNumber = new PhoneNumber("").getNumber();
		
		assertEquals(
	            expectedNumber, actualNumber
	        );
	}
	
	@Test
	public void test_NullString_ThrowsException() {
		try {
			PhoneNumber number = new PhoneNumber( null );
			fail("Supposed to catch NullPointerException");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Expected to catch NullPointerException");
		}
	}
	
	@Test
	public void test_LongGarbageString_ReturnsInvalidNumber() {
		final String expectedNumber = "0000000000";
		final String actualNumber = new PhoneNumber("aklsdjf;aklsjflak;jsfkl;ajs;kjagha;7*&^&*^dfhasudfhaksjd6786789a").getNumber();
		
		assertEquals(
	            expectedNumber, actualNumber
	        );
	}
	
	@Test
	public void test_ShortString_ReturnsInvalidNumber() {
		final String expectedNumber = "0000000000";
		final String actualNumber = new PhoneNumber("12345").getNumber();
		
		assertEquals(
	            expectedNumber, actualNumber
	        );
	}
	
	@Test
	public void test_10CharLongGarbageString_ReturnsInvalidNumber() {
		final String expectedNumber = "0000000000";
		final String actualNumber = new PhoneNumber("aaaaaaaaaa").getNumber();
		assertEquals(
	            expectedNumber, actualNumber
	        );
	}
	
    @Test
    public void cleansNumber() {
        final String expectedNumber = "1234567890";
        final String actualNumber = new PhoneNumber("(123) 456-7890").getNumber();

        assertEquals(
            expectedNumber, actualNumber
        );
    }

    @Test
    public void cleansNumberWithDots() {
        final String expectedNumber = "1234567890";
        final String actualNumber = new PhoneNumber("123.456.7890").getNumber();

        assertEquals(
            expectedNumber, actualNumber
        );
    }

    @Test
    public void validWhen11DigitsAndFirstIs1() {
        final String expectedNumber = "1234567890";
        final String actualNumber = new PhoneNumber("11234567890").getNumber();

        assertEquals(
            expectedNumber, actualNumber
        );
    }

    @Test
    public void invalidWhenOnly11Digits() {
        final String expectedNumber = "0000000000";
        final String actualNumber = new PhoneNumber("21234567890").getNumber();

        assertEquals(
            expectedNumber, actualNumber
        );
    }

    @Test
    public void invalidWhen9Digits() {
        final String expectedNumber = "0000000000";
        final String actualNumber = new PhoneNumber("123456789").getNumber();

        assertEquals(
            expectedNumber, actualNumber
        );
    }

    @Test
    public void areaCode() {
        final String expectedAreaCode = "123";
        final String actualAreaCode = new PhoneNumber("1234567890").getAreaCode();

        assertEquals(
            expectedAreaCode, actualAreaCode
        );
    }

    @Test
    public void prettyPrint() {
        final String expectedPrettyNumber = "(123) 456-7890";
        final String actualPrettyNumber = new PhoneNumber("1234567890").pretty();

        assertEquals(
            expectedPrettyNumber, actualPrettyNumber
        );
    }

    @Test
    public void prettyPrintWithFullUSPhoneNumber() {
        final String expectedPrettyNumber = "(123) 456-7890";
        final String actualPrettyNumber = new PhoneNumber("11234567890").pretty();

        assertEquals(
            expectedPrettyNumber, actualPrettyNumber
        );
    }

}
