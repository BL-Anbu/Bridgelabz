package Day27_28_Practice_problem.addressbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBookMap = new HashMap<>();

    // UC5 – Add Address Book
    public void addAddressBook(String name) {
        addressBookMap.put(name, new AddressBook());
    }

    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    // UC8 – View Persons by City or State
    public Map<String, List<ContactPerson>> viewByCity() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(ContactPerson::getCity));
    }

    public Map<String, List<ContactPerson>> viewByState() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(ContactPerson::getState));
    }

    // UC9 – Count by City or State
    public Map<String, Long> countByCity() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(
                        ContactPerson::getCity, Collectors.counting()));
    }

    public Map<String, Long> countByState() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(
                        ContactPerson::getState, Collectors.counting()));
    }
}
