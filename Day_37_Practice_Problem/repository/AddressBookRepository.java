package Day_37_Practice_Problem.repository;

import Day_37_Practice_Problem.model.Person;

import java.util.List;

public interface AddressBookRepository {

    void add(Person person);
    void update(String firstName, String lastName, Person updatedPerson);
    void delete(String firstName, String lastName);
    List<Person> findAll();
}

