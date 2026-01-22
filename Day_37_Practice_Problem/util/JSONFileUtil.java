package Day_37_Practice_Problem.util;

import Day_37_Practice_Problem.model.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JSONFileUtil {

    private static final String JSON_FILE_PATH = "Day_37_Practice_Problem/files/addressbook.json";
    private static final Gson gson = new Gson();

    // UC 10 / UC 13 – Write to JSON
    public static void writeToJson(List<Person> persons) {

        try {
            File file = new File(JSON_FILE_PATH);

            // ✅ Create parent directories if missing
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // ✅ Create file if missing
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(persons, writer);
                System.out.println("Address Book written to JSON successfully");
            }

        } catch (IOException e) {
            System.err.println("File creation failed: " + e.getMessage());
        }
    }



    // UC 10 / UC 13 – Read from JSON
    public static List<Person> readFromJson() {
        try (FileReader reader = new FileReader(JSON_FILE_PATH)) {

            Type personListType = new TypeToken<List<Person>>() {}.getType();
            return gson.fromJson(reader, personListType);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
