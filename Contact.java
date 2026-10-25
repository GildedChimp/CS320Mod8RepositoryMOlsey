// Michael Olsey
// CS-320
// 9/19/2026

package model;

public class Contact {
	
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	private boolean validateID(String contactID) {
		return contactID != null && contactID.length() <= 10;
	}
	
	private boolean validateFirstName(String firstName) {
		return firstName != null && firstName.length() <= 10;
	}
	
	private boolean validateLastName(String lastName) {
		return lastName != null && lastName.length() <= 10;
	}
	
	private boolean validatePhone(String phoneNumber) {
		return phoneNumber != null && phoneNumber.length() == 10;
	}
	
	private boolean validateAddress(String address) {
		return address != null && address.length() <= 30;
	}
	
	
	public Contact(String contactID,
			       String firstName,
			       String lastName,
			       String phoneNumber,
			       String address) {
		
		if (!validateID(contactID)) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		
		if (!validateFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		
		if (!validateLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name."); 
		}
		
		if (!validatePhone(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number."); 
		}
		
		if (!validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address"); 
		}
		
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		}
	
	
	public String getContactID() {
		return contactID;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (!validateFirstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (!validateLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		this.lastName = lastName;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber ) {
		if (!validatePhone(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if (!validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address.");
		}
		this.address = address;
	}
}
