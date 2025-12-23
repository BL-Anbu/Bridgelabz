package Day_22_Practice_problem;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner scanner = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        System.out.print("Enter Address Book Name: ");
        String bookName = scanner.nextLine();
        system.addAddressBook(bookName);

        AddressBook addressBook = system.getAddressBook(bookName);

        char choice;
        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Search by City");
            System.out.println("5. Search by State");
            System.out.println("6. Count by City");
            System.out.println("7. Count by State");
            System.out.println("0. Exit");

            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("First Name: ");
                    String fn = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String ln = scanner.nextLine();
                    System.out.print("Address: ");
                    String addr = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    System.out.print("Zip: ");
                    String zip = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    ContactPerson person = new ContactPerson(
                            fn, ln, addr, city, state, zip, phone, email
                    );
                    addressBook.addContact(person);
                    break;

                case 2:
                    System.out.print("Enter First Name to delete: ");
                    addressBook.deleteContact(scanner.nextLine());
                    break;

                case 3:
                    addressBook.displayContacts();
                    break;

                case 4:
                    System.out.print("Enter City: ");
                    system.searchByCity(scanner.nextLine())
                            .forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter State: ");
                    system.searchByState(scanner.nextLine())
                            .forEach(System.out::println);
                    break;

                case 6:
                    System.out.println(system.countByCity());
                    break;

                case 7:
                    System.out.println(system.countByState());
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;
            }

            System.out.print("Continue? (y/n): ");
            choice = scanner.next().charAt(0);
            scanner.nextLine();

        } while (choice == 'y');
    }
}

