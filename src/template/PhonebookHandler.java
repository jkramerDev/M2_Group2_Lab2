package template;

import java.util.*;

/**
 * PhonebookHandler - supports 
 * Phonebook operations
 * 
 * Use a map to build the Phonebook
 * key: Contact
 * value: List<phonebookEntries>
 */

public class PhonebookHandler implements iPhonebookHander{
	private List<Contact> contacts;			//initializes the list of contacts 
	private Map<Contact, List<PhonebookEntry>> phonebook;			//initializes the map of numbers for each contact

	public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {			//constructor method
		this.phonebook = phonebook;
	    this.contacts = new ArrayList<>(phonebook.keySet()); 
	}

	@Override
	public List<Contact> sortByName() {				//sorts the contacts by name 
		int size = contacts.size();			//determines the number of contacts 
        for (int i = 0; i < size - 1; i++) {			//starts with first contact then moves down the list 
            for (int k = 0; k < size - i - 1; k++) {			//starts with the first contact and also moves down the list
                if (contacts.get(k).getName().compareTo(contacts.get(k + 1).getName()) > 0) {		//if--> the first term is after the second in the alphabet : Switch terms 
                    Contact temp = contacts.get(k);			//k get put into temp
                    contacts.set(k, contacts.get(k + 1));			//k+1 gets put into k
                    contacts.set(k + 1, temp);			//temp gets put into k+1
                }
            }
        }
        return contacts;		//return contacts list
	}

	@Override
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
		int start = 0;			//set the start/min value
	    int end = sortedContacts.size() - 1;			//set the end/max value
	    
	    List<PhonebookEntry> foundList = new ArrayList<>();		//initializes the 'foundList' for contacts that have the searched for name
	    
	    while(start <= end) {			//while --> there are still contacts to be searched:
	        int mid = start + (end - start) / 2;			//middle = halfway between the start and end values 
	        Contact midContact = sortedContacts.get(mid);			//gets the middle contacts contact object
	        if(midContact.getName().compareTo(name) == 0) {			//if --> (previous lines) name is the same as the search name: 
	            foundList.add(new PhonebookEntry(midContact.getName(), midContact.getPhoneNumbers()));		//adds contact to foundList
	            int left = mid - 1;			//sets left value to one less than mid
	            while (left >= 0 && sortedContacts.get(left).getName().equals(name)) {			//checks all items to the left to see if they match the name
	                foundList.add(new PhonebookEntry(sortedContacts.get(left).getName(), sortedContacts.get(left).getPhoneNumbers()));		//adds contact to the foundList
	                left--;		//moves left once again
	            }
	            int right = mid + 1;		//sets right value to one more than mid
	            while (right < sortedContacts.size() && sortedContacts.get(right).getName().equals(name)) {		//checks all items to the right to see if they match the name
	                foundList.add(new PhonebookEntry(sortedContacts.get(right).getName(), sortedContacts.get(right).getPhoneNumbers()));		//adds contact to the foundList
	                right++;		//moves right one again
	            }
	            return foundList; 		//returns foundList
	        } else if (midContact.getName().compareTo(name) < 0) {		//if --> mid name is before searched name, move mid once to left
	            start = mid + 1; 	
	        } else {		//else --> mid name is after searched name, move mid once to right
	            end = mid - 1; 
	        }
		}
	    System.out.println("ERROR: USER NOT FOUND.");		//if user isnt found this line will run

		return foundList;
	}

	@Override
	public void display(List<Contact> sortedContacts) {
		for (Contact contact : sortedContacts) {		//for every contact in the contact list:
            System.out.println("Name: " + contact.getName());		//prints name of contact
            System.out.println("Phone Numbers:");
            for (Map.Entry<String, int[]> entry : contact.getPhoneNumbers().entrySet()) {	//for every phone number that the contact has:
                String type = entry.getKey();		//gets the type of phone number
                int[] numbers = entry.getValue();		//gets the phone number
                System.out.print(type + ": ");		//displays "type: xxxxxxxxxx"
                for (int number : numbers) {		
                    System.out.print(number + " ");
                }
                System.out.println();	//goes down one line 
            }
            System.out.println();
	}

	}
}
