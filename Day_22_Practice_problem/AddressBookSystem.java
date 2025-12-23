package Day_22_Practice_problem;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBookMap = new HashMap<>();

    // UC: Add new Address Book
    public void addAddressBook(String name) {
        if (addressBookMap.containsKey(name)) {
            System.out.println("Address Book already exists");
            return;
        }
        addressBookMap.put(name, new AddressBook());
        System.out.println("Address Book created successfully");
    }

    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    // UC: Search by city
    public List<ContactPerson> searchByCity(String city) {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // UC: Search by state
    public List<ContactPerson> searchByState(String state) {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(p -> p.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // UC: View persons by city
    public Map<String, List<ContactPerson>> viewByCity() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(ContactPerson::getCity));
    }

    // UC: View persons by state
    public Map<String, List<ContactPerson>> viewByState() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(ContactPerson::getState));
    }

    // UC: Count by city
    public Map<String, Long> countByCity() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(
                        ContactPerson::getCity,
                        Collectors.counting()
                ));
    }

    // UC: Count by state
    public Map<String, Long> countByState() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(
                        ContactPerson::getState,
                        Collectors.counting()
                ));
    }
}

