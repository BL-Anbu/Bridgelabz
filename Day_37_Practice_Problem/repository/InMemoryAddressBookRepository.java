package Day_37_Practice_Problem.repository;

import Day_37_Practice_Problem.model.Person;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAddressBookRepository implements AddressBookRepository {

    private final List<Person> persons = new ArrayList<>();

    @Override
    public void add(Person person) {
        if (persons.contains(person)) {
            throw new RuntimeException("Duplicate person entry");
        }
        persons.add(person);
    }

    @Override
    public void update(String firstName, String lastName, Person updatedPerson) {
        persons.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(firstName)
                        && p.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .ifPresent(p -> {
                    p.setAddress(updatedPerson.getCity());
                    p.setCity(updatedPerson.getCity());
                    p.setState(updatedPerson.getState());
                    p.setZip(updatedPerson.getZip());
                    p.setPhoneNumber(updatedPerson.getZip());
                });
    }

    @Override
    public void delete(String firstName, String lastName) {
        persons.removeIf(p ->
                p.getFirstName().equalsIgnoreCase(firstName) &&
                        p.getLastName().equalsIgnoreCase(lastName));
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }
}
