// Michael Olsey
// CS320
// 9/20/2026

package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


class ContactTest {
	
	private Contact testContact;
	
	@BeforeEach
	void setUp( ) {
		testContact = new Contact(
				"1",
				"Mike",
				"Olsey",
				"1234567891",
				"111 Main Street");
	}

	@Test
	@DisplayName("Test valid constructor")
	void testValidConstructor() {
		Contact contact = new Contact(
				"1",
				"Mike",
				"Olsey",
				"1234567891",
				"111 Main Street");
		
		assertAll(
				() -> assertEquals("1", contact.getContactID()),
				() -> assertEquals("Mike", contact.getFirstName()),
				() -> assertEquals("Olsey", contact.getLastName()),
				() -> assertEquals("1234567891", contact.getPhoneNumber()),
				() -> assertEquals("111 Main Street", contact.getAddress()));
	}
	
	
	
	
	@Test
	@DisplayName("Test valid setFirstName")
	void testSetFirstNameValid() {
		testContact.setFirstName("Test");
		
		assertEquals("Test", testContact.getFirstName());
	}
	
	@Test
	@DisplayName("Test null setFirstName")
	void testSetFirstNameNull() {
		assertThrows(
				IllegalArgumentException.class,
				() -> testContact.setFirstName(null));
	}
	
	@Test
	@DisplayName("Test excessively long setFirstName")
	void testSetFirstNameTooLong() {
		assertThrows(
				IllegalArgumentException.class,
				() -> testContact.setFirstName("FirstNameTooLong"));
	}
	
	@Test
	@DisplayName("Test valid setLastName")
	void testSetLastNameValid() {
		testContact.setLastName("Test");
		
		assertEquals("Test", testContact.getLastName());
	}
	
	@Test
	@DisplayName("Test null setLastName")
	void testSetLastNameNull() {
		assertThrows(
				IllegalArgumentException.class,
				() -> testContact.setLastName(null));
	}
	
	@Test
	@DisplayName("Test excessively long setLastName")
	void testSetLastNameTooLong() {
		assertThrows(
				IllegalArgumentException.class,
				() -> testContact.setLastName("LastNameTooLong"));
	}
	
	@Test
	@DisplayName("Test invalid phone number in costructor")
	void testInvalidConstructorPhoneNumber() {
		assertThrows(
				IllegalArgumentException.class,
				() -> new Contact(
						"2",
						"Mike",
						"Olsey",
						"1",
						"111 Main Street"));
	}
	
	@Test
	@DisplayName("Test null setPhoneNumber")
	void testSetPhoneNumberNull() {
		assertThrows(
				IllegalArgumentException.class,
				() -> testContact.setPhoneNumber(null));
	}
	
	@DisplayName("Reject phone number shorter than 10 digits")
	@Test
	void testPhoneNumberTooShort() {
	    assertThrows(
	        IllegalArgumentException.class,
	        () -> testContact.setPhoneNumber("12345678")
	    );
	}

	@DisplayName("Reject phone number longer than 10 digits")
	@Test
	void testPhoneNumberTooLong() {
	    assertThrows(
	        IllegalArgumentException.class,
	        () -> testContact.setPhoneNumber("123456789101112131415")
	    );
	}

	@DisplayName("Accept a valid 10-digit phone number")
	@Test
	void testValidPhoneNumber() {
	    testContact.setPhoneNumber("1987654321");

	    assertEquals("1987654321", testContact.getPhoneNumber());
	}
	
	@DisplayName("Test a valid setAddress")
	@Test
    void testGoodAddress() {
	    testContact.setAddress("987 Good Address");

	    assertEquals("987 Good Address", testContact.getAddress());
	}
	
	@Test
	@DisplayName("setAddress rejects null")
	public void testNullSetAddress() {
	    assertThrows(
	        IllegalArgumentException.class,
	        () -> testContact.setAddress(null));
	}
	
	@Test
	@DisplayName("setAddress rejects addresses longer than 30 characters")
	public void testWrongLengthAddress() {
	    assertThrows(
	        IllegalArgumentException.class,
	        () -> testContact.setAddress("123456789 Address xxxxxxxToo Longxxxxxxx Street"));
	}

}
