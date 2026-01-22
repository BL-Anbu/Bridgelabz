package Day_37_Practice_Problem.util;

import Day_37_Practice_Problem.model.Person;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVFileUtil {

    private static final String CSV_FILE_PATH = "Day_37_Practice_Problem/files/csvfile.csv";


    // UC 11 / UC 12 – Read from CSV
    public static List<Person> readFromCSV() {
        List<Person> persons = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            String[] line;
            reader.readNext(); // Skip header

            while ((line = reader.readNext()) != null) {
                Person person = new Person(
                        line[0], // firstName
                        line[1], // lastName
                        line[2], // address
                        line[3], // city
                        line[4], // state
                        line[5], // zip
                        line[6]  // phone
                );
                persons.add(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static void writeToCSV(List<Person> persons) {

        try {
            File file = new File(CSV_FILE_PATH);

            // ✅ Check if file exists, else create
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("CSV file created: " + file.getName());
                }
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {

                // Header
                writer.writeNext(new String[]{
                        "FirstName", "LastName", "Address",
                        "City", "State", "Zip", "Phone"
                });

                // Data
                for (Person person : persons) {
                    writer.writeNext(new String[]{
                            person.getFirstName(),
                            person.getLastName(),
                            person.getAddress(),
                            person.getCity(),
                            person.getState(),
                            person.getZip(),
                            person.getPhoneNumber()
                    });
                }

                System.out.println("Address Book written to CSV successfully");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
