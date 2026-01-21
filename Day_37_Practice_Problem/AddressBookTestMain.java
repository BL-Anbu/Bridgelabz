package Day_37_Practice_Problem;



import Day_37_Practice_Problem.model.Person;
import Day_37_Practice_Problem.service.AddressBookService;
import Day_37_Practice_Problem.service.AddressBookServiceImpl;
import Day_37_Practice_Problem.util.CSVFileUtil;
import Day_37_Practice_Problem.util.JSONFileUtil;
import Day_37_Practice_Problem.util.JsonServerUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddressBookTestMain {

    public static void main(String[] args) {

        System.out.println("===== ADDRESS BOOK TEST STARTED =====");

        AddressBookService service = new AddressBookServiceImpl();

        // ---------------- UC 1–UC 5 ----------------
        Person p1 = new Person("Anbu", "A", "Street 1",
                "Chennai", "Tamil Nadu", "600001", "9876543210");

        Person p2 = new Person("Ravi", "K", "Street 2",
                "Bangalore", "Karnataka", "560001", "9876501234");

        Person p3 = new Person("Suresh", "M", "Street 3",
                "Chennai", "Tamil Nadu", "600002", "9123456780");

        service.addPerson(p1);
        service.addPerson(p2);
        service.addPerson(p3);

        System.out.println("\nAll Persons:");
        service.getAllPersons().forEach(System.out::println);

        // ---------------- UC 6 ----------------
        System.out.println("\nSorted By Name:");
        service.sortByName().forEach(System.out::println);

        // ---------------- UC 7 ----------------
        System.out.println("\nSorted By City:");
        service.sortByCity().forEach(System.out::println);

        // ---------------- UC 8 ----------------
        System.out.println("\nGroup By City:");
        service.groupByCity().forEach((city, persons) -> {
            System.out.println(city + " -> " + persons);
        });

        // ---------------- UC 9 ----------------
        System.out.println("\nSearch By State: Tamil Nadu");
        service.searchByState("Tamil Nadu").forEach(System.out::println);

        // ---------------- UC 10 & UC 13 (JSON File) ----------------
        System.out.println("\nWriting to JSON File...");
        JSONFileUtil.writeToJson(service.getAllPersons());

        System.out.println("Reading from JSON File...");
        List<Person> jsonPersons = JSONFileUtil.readFromJson();
        jsonPersons.forEach(System.out::println);

        // ---------------- UC 11 & UC 12 (CSV File) ----------------
        System.out.println("\nWriting to CSV File...");
        CSVFileUtil.writeToCSV(service.getAllPersons());

        System.out.println("Reading from CSV File...");
        List<Person> csvPersons = CSVFileUtil.readFromCSV();
        csvPersons.forEach(System.out::println);

        // ---------------- UC 14 (JSON Server) ----------------
        System.out.println("\nPosting person to JSON Server...");
        JsonServerUtil.postPerson(p1);

        System.out.println("\nFetching persons from JSON Server...");
        JsonServerUtil.getPersons();

        // ---------------- UC 15 (Non-blocking IO) ----------------
        System.out.println("\nRunning IO operations using Multithreading...");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> JSONFileUtil.writeToJson(service.getAllPersons()));
        executor.execute(() -> CSVFileUtil.writeToCSV(service.getAllPersons()));

        executor.shutdown();

        System.out.println("===== ADDRESS BOOK TEST COMPLETED =====");
    }
}

