package Day27_Practice_problem.addressbook;
import java.io.*;
import java.util.List;

public class FileIOService {

    private static final String FILE_NAME = "Day27_Practice_problem/addressbook/files/addressbook.txt";

    public void writeToFile(List<ContactPerson> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (ContactPerson p : contacts) {
                writer.write(p.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

