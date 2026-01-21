package Day_35_Practice_Problem.AddressBook_Service.java.service;


import Day_35_Practice_Problem.AddressBook_Service.java.dao.AddressBookDAO;
import Day_35_Practice_Problem.AddressBook_Service.java.dao.AddressBookDAOImpl;
import Day_35_Practice_Problem.AddressBook_Service.java.model.ContactPerson;

public class AddressBookService {

    private final AddressBookDAO dao = new AddressBookDAOImpl();

    public void addContact(ContactPerson person) {
        dao.addContact(person);
    }

    public void editContact(ContactPerson person) {
        dao.updateContact(person);
    }

    public void deleteContact(String firstName, String lastName) {
        dao.deleteContact(firstName, lastName);
    }
}
