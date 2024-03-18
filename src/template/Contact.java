package template;

<<<<<<< Updated upstream
import java.util.HashMap;
import java.util.List;
import java.util.Map;

=======
>>>>>>> Stashed changes
/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

<<<<<<< Updated upstream
class Contact {		
	private String name;			//initializes name for contact 
	private Map<String, int[]> phoneNumbers;			//initializes phone number map along with the type of number 
	
	public Contact(String name) {			//constructor method 
		this.name = name;
		this.phoneNumbers = new HashMap<>();
	}
	
	public void setName(String name) {			//mutator method
		this.name = name;
	}
	
	public String getName() {			//accessor method
		return name;
	}
	
	public Map<String, int[]> getPhoneNumbers() {			//accessor method
		return phoneNumbers;
	}

	public void addPhonebookEntry(String number, String type) {			//mutator method
		long num = Long.parseLong(number); 
		int[] nums = {(int) num};
        phoneNumbers.put(type, nums);
    }

	public List<PhonebookEntry> getPhonebookEntries() {			//accessor method
		// TODO Auto-generated method stub
		return null;
	}
	
=======
class Contact {
	  private String name ;
	  private int[] phonenumbers;
	  private int i = 0;
	  
	  public Contact(String name) {
		  this.name = name;
	  }
	  
	  public void addNumber (int number) {
		  phonenumbers[i] = number;
		  i++;
	  }
	  
	  public int[] getNumbers(){
		return phonenumbers;
	  }
	  
	  
>>>>>>> Stashed changes
}
