// Michael Olsey
// CS320
// 9/20/2026

package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import model.Contact;


class ContactServiceTest {
	
	private ContactService service;
	
	private final String firstName = "Mike";
	private final String lastName = "Olsey";
	private final String phoneNumber = "1234567891";
	private final String address = "111 Main Street";

	@BeforeEach
	void setUp() {
		service = new ContactService();
	}
	
	@AfterEach
	void tearDown() {
		ContactService.contactList.clear();
	}
	

	@Test
	@DisplayName("Add a contact successfully")
	void testAddContact() {
		
		assertTrue(ContactService.contactList.isEmpty());
		service.addContact(firstName, lastName, phoneNumber, address);
		assertEquals(1, ContactService.contactList.size());
		
		Contact contact = service.getContact("0");
		
		assertNotNull(contact);
		assertEquals("0", contact.getContactID());
		assertEquals(firstName, contact.getFirstName());
		assertEquals(lastName, contact.getLastName());
		assertEquals(phoneNumber, contact.getPhoneNumber());
		assertEquals(address, contact.getAddress());
	}
	
	@Test
	@DisplayName("Delete a contact successfully")
	void testDeleteContact() {
		
		service.addContact(firstName, lastName, phoneNumber, address);
		service.addContact(firstName, lastName, phoneNumber, address);
		service.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(3, ContactService.contactList.size());
		assertNotNull(service.getContact("1"));
		service.deleteContact("1");
		assertEquals(2, ContactService.contactList.size());
		assertNull(service.getContact("1"));
	}
	
	@Test
	@DisplayName("Successfully edit a first name")
	void testEditFirstName() {
		
		service.addContact(firstName, lastName, phoneNumber, address);
		
		Contact contact = service.getContact("0");
		
		assertNotNull(contact);
		assertEquals(firstName, contact.getFirstName());
		service.editFirstName("0", "TEST_FIRST");
		assertEquals("TEST_FIRST", contact.getFirstName());
	}
	
	@Test
	@DisplayName("Successfully edit a last name")
	void testEditLastName() {
		
		service.addContact(firstName, lastName, phoneNumber, address);
		
		Contact contact = service.getContact("0");
		
		assertNotNull(contact);
		assertEquals(lastName, contact.getLastName());
		service.editLastName("0", "TEST_LAST");
		assertEquals("TEST_LAST", contact.getLastName());
	}
	
	@Test
	@DisplayName("Edit a phone numbeer Successfully")
	void testEditPhone() {
		
		service.addContact(firstName, lastName, phoneNumber, address);
		
		Contact contact = service.getContact("0");
		
		assertNotNull(contact);
		assertEquals(phoneNumber, contact.getPhoneNumber());
		service.editNumber("0", "1987654321");
		assertEquals("1987654321", contact.getPhoneNumber());
	}
	
	@Test
	@DisplayName("Successfully edit an address")
	void testEditAddress() {
		
		service.addContact(firstName, lastName, phoneNumber, address);
		
		Contact contact = service.getContact("0");
		
		assertNotNull(contact);
		assertEquals(address, contact.getAddress());
		service.editAddress("0", "TEST_ADDRESS");
		assertEquals("TEST_ADDRESS", contact.getAddress());
	}
}
