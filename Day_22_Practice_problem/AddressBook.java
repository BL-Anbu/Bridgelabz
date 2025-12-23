package Day_22_Practice_problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook {

    private List<ContactPerson> contactList = new ArrayList<>();

    // UC: Add contact with duplicate check
    public void addContact(ContactPerson contact) {
        boolean duplicate = contactList.stream()
                .anyMatch(p -> p.getFirstName()
                        .equalsIgnoreCase(contact.getFirstName()));

        if (duplicate) {
            System.out.println("Duplicate contact not allowed");
            return;
        }
        contactList.add(contact);
        System.out.println("Contact added successfully");
    }

    // UC: Delete contact by name
    public void deleteContact(String firstName) {
        Iterator<ContactPerson> iterator = contactList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            ContactPerson person = iterator.next();
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                found = true;
                System.out.println("Contact deleted successfully");
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found");
        }
    }

    public List<ContactPerson> getContacts() {
        return contactList;
    }

    public void displayContacts() {
        contactList.forEach(System.out::println);
    }
}
