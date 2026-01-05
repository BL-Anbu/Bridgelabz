package Day27_28_Practice_problem.addressbook;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JSONFileService {

    private static final String JSON_FILE = "Day27_28_Practice_problem/addressbook/files/addressbook.json";
    private Gson gson = new Gson();

    public void writeJSON(List<ContactPerson> contacts) {
        try (Writer writer = new FileWriter(JSON_FILE)) {
            gson.toJson(contacts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readJSON() {
        try (Reader reader = new FileReader(JSON_FILE)) {
            Type type = new TypeToken<List<ContactPerson>>() {}.getType();
            List<ContactPerson> contacts = gson.fromJson(reader, type);
            contacts.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}