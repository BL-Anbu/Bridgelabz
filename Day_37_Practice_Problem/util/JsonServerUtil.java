package Day_37_Practice_Problem.util;

import Day_37_Practice_Problem.model.Person;
import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JsonServerUtil {

    private static final String SERVER_URL = "http://localhost:3000/persons";
    private static final Gson gson = new Gson();

    // UC 14 – POST Person to JSON Server
    public static void postPerson(Person person) {
        try {
            URL url = new URL(SERVER_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = gson.toJson(person);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
            }

            System.out.println("Person posted to JSON Server, Response Code: "
                    + conn.getResponseCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UC 14 – GET Persons from JSON Server
    public static void getPersons() {
        try {
            URL url = new URL(SERVER_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
