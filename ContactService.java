// Michael Olsey 
// CS320
// 9/19/2026

package service;

import java.util.HashMap;
import java.util.Map;
import model.Contact;


public class ContactService {
	
	public static Map<String, Contact> contactList = new HashMap<>();
	private int currentIDNum = 0;
	
	public void addContact(String firstName, String lastName, 
			               String phoneNumber, String address) {
		
		String contactID = String.valueOf(currentIDNum);
		
		Contact contact = new Contact(
										contactID,
										firstName,
										lastName,
										phoneNumber,
										address);
		
		contactList.put(contactID, contact);
		currentIDNum++;
	}
	
	public Contact getContact(String contactID) {
		return contactList.get(contactID);
	}
	
	
	public void deleteContact(String contactID) {
		contactList.remove(contactID);
	}
	
	
	public void editFirstName(String contactID, String firstName) {
		Contact contact = contactList.get(contactID);
		
		if (contact != null) {
				contact.setFirstName(firstName);
		}
	}
	
	public void editLastName(String contactID, String lastName) {
		Contact contact = contactList.get(contactID);
		
		if (contact != null) {
				contact.setLastName(lastName);
		}
	}
		
	public void editNumber(String contactID, String phoneNumber) {
		Contact contact = contactList.get(contactID);
			
		if (contact != null) {
				contact.setPhoneNumber(phoneNumber);
		}
	}
		
	public void editAddress(String contactID, String address) {
		Contact contact = contactList.get(contactID);
			
		if (contact != null) {
				contact.setAddress(address);
		}
	}
}