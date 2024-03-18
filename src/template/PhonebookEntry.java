package template;

import java.util.Map;

/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
 *   
 *   
 *   
 */



//this is just copied from the contact class as most of the same information is used in both

class PhonebookEntry{

	private String name;			//initializes name for contact 
	private Map<String, int[]> phoneNumbers;			//initializes phone number map along with the type of number
	
	public PhonebookEntry(String name, Map<String, int[]> map) {			//constructor method
		this.name = name;
		this.phoneNumbers = map;
	}
	
	public void setName(String name) {			//mutator method
		this.name = name;
	}
	
	public void setPhoneNumber(Map<String, int[]> phoneNumbers) {			//mutator method
		this.phoneNumbers = phoneNumbers ;
	}
	
	public String getName() {			//accessor method
		return name;
	}
	
	public Map<String, int[]> getPhoneNumbers() {			//accessor method
		return phoneNumbers;
	}

	public String getType() {			//accessor method
		for (String key : phoneNumbers.keySet()) {
	        return key;
	    }
	    return null;
	}
	
 
}
	