package Day_37_Practice_Problem.service;


import Day_37_Practice_Problem.model.Person;
import Day_37_Practice_Problem.repository.AddressBookRepository;
import Day_37_Practice_Problem.repository.InMemoryAddressBookRepository;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookServiceImpl implements AddressBookService {

    private final AddressBookRepository repository = new InMemoryAddressBookRepository();

    @Override
    public void addPerson(Person person) {
        repository.add(person);
    }

    @Override
    public void editPerson(String firstName, String lastName, Person updatedPerson) {
        repository.update(firstName, lastName, updatedPerson);
    }

    @Override
    public void deletePerson(String firstName, String lastName) {
        repository.delete(firstName, lastName);
    }

    @Override
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @Override
    public List<Person> sortByName() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> sortByCity() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Person::getCity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> sortByState() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Person::getState))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> sortByZip() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Person::getZip))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Person>> groupByCity() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public Map<String, List<Person>> groupByState() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(Person::getState));
    }

    @Override
    public List<Person> searchByCity(String city) {
        return repository.findAll().stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> searchByState(String state) {
        return repository.findAll().stream()
                .filter(p -> p.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }
}

