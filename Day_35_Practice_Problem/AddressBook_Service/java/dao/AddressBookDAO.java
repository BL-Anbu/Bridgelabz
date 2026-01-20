package Day_35_Practice_Problem.AddressBook_Service.java.dao;

import Day_35_Practice_Problem.AddressBook_Service.java.model.ContactPerson;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AddressBookDAO {

    boolean addContact(ContactPerson person);

    boolean updateContact(ContactPerson person);

    boolean deleteContact(String firstName, String lastName);

    List<ContactPerson> getAllContacts();

    List<ContactPerson> getContactsByCity(String city);

    Map<String, Long> getCountByState();

    List<ContactPerson> getContactsAddedBetween(LocalDate start, LocalDate end);
}
