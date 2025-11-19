package Day_9_Practice_Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    private static final List<Contacts> contacts = new ArrayList<Contacts>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("---------- Welcome to Address Book System ----------");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    addContactFlow();
                    break;
                case "2":
                    editContactFlow();
                    break;
                case "3":
                    listContactsFlow();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting Address Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
            System.out.println();
        sc.close();
    }

    private static void listContactsFlow() {
        System.out.println("--- All Contacts ---");
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        int i = 1;
        for (Contacts c : contacts) {
            System.out.printf("%d. %s %s | %s | %s | %s | %s | %s%n",
                    i++,
                    c.getFirstName(), c.getLastName(),
                    c.getEmail(), c.getAddress(), c.getCity(),
                    c.getPhoneNo(), c.getPinCode());
        }
    }


    private static void printMenu() {
        System.out.println("=== Address Book Menu ===");
        System.out.println("1. Add Contact");
        System.out.println("2. Edit Contact (by first + last name)");
        System.out.println("3. List Contacts");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addContactFlow() {
        System.out.println("--- Add New Contact ---");
        Contacts c = readContactDetails();
        contacts.add(c);
        System.out.println("Contact added: " + c.getFirstName() + " " + c.getLastName());
    }

    private static int findContactIndex(String firstName, String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            Contacts c = contacts.get(i);
            if (c.getFirstName().equalsIgnoreCase(firstName)
                    && c.getLastName().equalsIgnoreCase(lastName)) {
                return i;
            }
        }
        return -1;
    }

    private static Contacts readContactDetails(Contacts existing) {
        Contacts person = new Contacts();

        System.out.print("First Name [" + existing.getFirstName() + "]: ");
        String first = sc.nextLine().trim();
        person.setFirstName(first.isEmpty() ? existing.getFirstName() : first);

        System.out.print("Last Name [" + existing.getLastName() + "]: ");
        String last = sc.nextLine().trim();
        person.setLastName(last.isEmpty() ? existing.getLastName() : last);

        System.out.print("Email [" + existing.getEmail() + "]: ");
        String email = sc.nextLine().trim();
        person.setEmail(email.isEmpty() ? existing.getEmail() : email);

        System.out.print("Address [" + existing.getAddress() + "]: ");
        String addr = sc.nextLine().trim();
        person.setAddress(addr.isEmpty() ? existing.getAddress() : addr);

        System.out.print("City [" + existing.getCity() + "]: ");
        String city = sc.nextLine().trim();
        person.setCity(city.isEmpty() ? existing.getCity() : city);

        System.out.print("Phone No [" + existing.getPhoneNo() + "]: ");
        String phone = sc.nextLine().trim();
        person.setPhoneNo(phone.isEmpty() ? existing.getPhoneNo() : phone);

        System.out.print("Pin Code [" + existing.getPinCode() + "]: ");
        String pin = sc.nextLine().trim();
        person.setPinCode(pin.isEmpty() ? existing.getPinCode() : pin);

        System.out.println();
        return person;
    }

    private static void editContactFlow() {
        System.out.println("--- Edit Contact ---");
        System.out.print("Enter first name of contact to edit: ");
        String first = sc.nextLine().trim();
        System.out.print("Enter last name of contact to edit: ");
        String last = sc.nextLine().trim();

        int idx = findContactIndex(first, last);
        if (idx == -1) {
            System.out.println("Contact not found for: " + first + " " + last);
            return;
        }

        Contacts existing = contacts.get(idx);
        System.out.println("Editing contact: " + existing);

        // read updated details (press Enter to keep existing)
        Contacts updated = readContactDetails(existing);
        // replace existing contact
        contacts.set(idx, updated);
        System.out.println("Contact updated.");
    }


    private static Contacts readContactDetails() {
        Contacts person = new Contacts();
        System.out.print("Enter your First Name : ");
        person.setFirstName(sc.next());
        System.out.print("Enter your Last Name : ");
        person.setLastName(sc.next());
        System.out.print("Enter your Email Id : ");
        person.setEmail(sc.next());
        System.out.print("Enter your City : ");
        person.setCity(sc.next());
        System.out.print("Enter your Address : ");
        person.setAddress(sc.next());
        System.out.print("Enter your Phone No : ");
        person.setPhoneNo(sc.next());
        System.out.print("Enter your Pin Code : ");
        person.setPinCode(sc.next());
        System.out.println();
        return person;
    }
}
