package Day27_28_Practice_problem.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    private List<ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson person) {
        if (contacts.contains(person)) {
            System.out.println("Duplicate contact not allowed!");
            return;
        }
        contacts.add(person);
    }

    public List<ContactPerson> getContacts() {
        return contacts;
    }

    // UC10 – Sort by Name
    public void sortByName() {
        contacts = contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getFirstName)
                        .thenComparing(ContactPerson::getLastName))
                .collect(Collectors.toList());

        contacts.forEach(System.out::println);
    }

    // UC11 – Sort by City
    public void sortByCity() {
        contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getCity))
                .forEach(System.out::println);
    }

    // UC11 – Sort by State
    public void sortByState() {
        contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getState))
                .forEach(System.out::println);
    }

    // UC11 – Sort by Zip
    public void sortByZip() {
        contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getZip))
                .forEach(System.out::println);
    }
}
