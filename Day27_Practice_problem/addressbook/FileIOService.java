package Day27_Practice_problem.addressbook;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileIOService {

    private static final String FILE_NAME = "Day27_Practice_problem/addressbook/addressbook.txt";

    public void writeToFile(List<ContactPerson> contacts) {
        try {
            Files.write(Paths.get(FILE_NAME),
                    contacts.stream().map(ContactPerson::toString).toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            Files.lines(Paths.get(FILE_NAME))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

