package Day27_28_Practice_problem.addressbook;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.List;

public class CSVFileService {

    private static final String CSV_FILE = "Day27_28_Practice_problem/addressbook/files/addressbook.csv";

    public void writeCSV(List<ContactPerson> contacts) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            for (ContactPerson p : contacts) {
                writer.writeNext(new String[]{
                        p.getFirstName(),
                        p.getLastName(),
                        p.getCity(),
                        p.getState(),
                        p.getZip(),
                        p.getPhone(),
                        p.getEmail()
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println(String.join(", ", line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
