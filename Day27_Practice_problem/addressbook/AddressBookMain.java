package Day27_Practice_problem.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner sc = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        system.addAddressBook("Personal");
        AddressBook book = system.getAddressBook("Personal");

        ContactPerson p1 = new ContactPerson(
                "Anbu", "A", "Street1", "Chennai",
                "TN", "600001", "9876543210", "anbu@mail.com");

        ContactPerson p2 = new ContactPerson(
                "Raj", "K", "Street2", "Bangalore",
                "KA", "560001", "9999999999", "raj@mail.com");

        book.addContact(p1);
        book.addContact(p2);

        book.sortByName();
        book.getContacts().forEach(System.out::println);

        FileIOService fileIO = new FileIOService();
        fileIO.writeToFile(book.getContacts());
        fileIO.readFromFile();
    }
}
