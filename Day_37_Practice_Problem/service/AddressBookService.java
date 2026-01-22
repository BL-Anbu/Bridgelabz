package Day_37_Practice_Problem.service;

import Day_37_Practice_Problem.model.Person;

import java.util.List;
import java.util.Map;

public interface AddressBookService {

    void addPerson(Person person);
    void editPerson(String firstName, String lastName, Person updatedPerson);
    void deletePerson(String firstName, String lastName);

    List<Person> getAllPersons();

    List<Person> sortByName();
    List<Person> sortByCity();
    List<Person> sortByState();
    List<Person> sortByZip();

    Map<String, List<Person>> groupByCity();
    Map<String, List<Person>> groupByState();

    List<Person> searchByCity(String city);
    List<Person> searchByState(String state);
}
