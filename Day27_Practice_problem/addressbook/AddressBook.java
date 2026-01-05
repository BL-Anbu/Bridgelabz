package Day27_Practice_problem.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    private List<ContactPerson> contacts = new ArrayList<>();

    // UC1 – Add Contact
    public void addContact(ContactPerson person) {
        if (contacts.stream().anyMatch(p -> p.equals(person))) {
            System.out.println("Duplicate Contact Not Allowed!");
            return;
        }
        contacts.add(person);
    }

    // UC2 – Edit Contact
    public void editContact(String firstName, String lastName, ContactPerson updated) {
        contacts.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(firstName)
                        && p.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .ifPresent(p -> {
                    contacts.remove(p);
                    contacts.add(updated);
                });
    }

    // UC3 – Delete Contact
    public void deleteContact(String firstName, String lastName) {
        contacts.removeIf(p ->
                p.getFirstName().equalsIgnoreCase(firstName)
                        && p.getLastName().equalsIgnoreCase(lastName));
    }

    // UC7 – Search by City or State
    public List<ContactPerson> searchByCityOrState(String value) {
        return contacts.stream()
                .filter(p -> p.getCity().equalsIgnoreCase(value)
                        || p.getState().equalsIgnoreCase(value))
                .collect(Collectors.toList());
    }

    // UC10 – Sort by Name
    public void sortByName() {
        contacts.sort(Comparator.comparing(ContactPerson::getFirstName));
    }

    // UC11 – Sort by City / State / Zip
    public void sortByCity() {
        contacts.sort(Comparator.comparing(ContactPerson::getCity));
    }

    public void sortByState() {
        contacts.sort(Comparator.comparing(ContactPerson::getState));
    }

    public void sortByZip() {
        contacts.sort(Comparator.comparing(ContactPerson::getZip));
    }

    public List<ContactPerson> getContacts() {
        return contacts;
    }
}
