package Day27_28_Practice_problem.addressbook;
public class AddressBookMain {

    //Need to add the dependencies to run this application
//    <dependency>
//    <groupId>com.opencsv</groupId>
//    <artifactId>opencsv</artifactId>
//    <version>5.9</version>
//    </dependency>
//    <dependency>
//    <groupId>com.google.code.gson</groupId>
//    <artifactId>gson</artifactId>
//    <version>2.10.1</version>
//    </dependency>

// Add this dependency in the settings -> project structures -> Libraries


    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        AddressBook book = new AddressBook();

        book.addContact(new ContactPerson(
                "Anbu", "A", "Street1", "Chennai",
                "TN", "600001", "9876543210", "anbu@mail.com"));

        book.addContact(new ContactPerson(
                "Raj", "K", "Street2", "Bangalore",
                "KA", "560001", "9999999999", "raj@mail.com"));

        System.out.println("\n--- Sort By Name ---");
        book.sortByName();

        System.out.println("\n--- Sort By City ---");
        book.sortByCity();

        System.out.println("\n--- Sort By State ---");
        book.sortByState();

        System.out.println("\n--- Sort By Zip ---");
        book.sortByZip();

        FileIOService fileIO = new FileIOService();
        fileIO.writeToFile(book.getContacts());
        fileIO.readFromFile();

        CSVFileService csvService = new CSVFileService();
        csvService.writeCSV(book.getContacts());
        csvService.readCSV();

        JSONFileService jsonService = new JSONFileService();
        jsonService.writeJSON(book.getContacts());
        jsonService.readJSON();
    }
}
