package File_Handling;

import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHandlingAndLoggingDemo {

    public static void main(String[] args) throws IOException {
        createFile();
        writeFile();
//        createFileNIO();
//        writeFileNIO();
        appendToFileIO();
//        appendToFileNIO();
//        readFileIo();
        readFileNIO();
        updateFileIO("Hello,World", "Hello,Using-IO-UPDATED");
        updateFileNIO("Hello1,World", "Hello1,using-NIO-UPDATED");
        readFileIo();
        redirectConsoleToFIle();
//        deleteFileNIO();
    }

    public static void createFile() throws IOException {
        File dir = new File("File_Handling/data");
        if (!dir.exists()) {
            dir.mkdirs();
        } else {
            System.out.println(true);
        }
        File file = new File(dir, "sample.txt");
        if (file.createNewFile()) {
            System.out.println("File Created...");
        } else {
            System.out.println("File already Exists...");
        }
    }

    public static void createFileNIO() throws IOException {
        try {
            Path path = Paths.get("File_Handling", "data", "sample.txt");

            if (Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("File created Successfully using (NIO).....");
            } else {
                System.out.println("File is already Exists....");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() throws IOException {
        String dirPath = "File_Handling/data";
        String filePath = dirPath + "/sample.txt";
        File dir = new File(dirPath);
        try {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write("Hello,World \nHello1,World\nThis file is handled by JAVA! ");
                writer.newLine();
                writer.write("This is written using java.io");
                System.out.println("File written successfully (java.io)");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileNIO() throws IOException {
        try {
            Path path = Paths.get("File_Handling", "data", "sample.txt");
            if (Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            Files.write(path, "Hello,World \nThis file is handled by JAVA!".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File Written Successfully using (java.nio)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendToFileIO() {
        String dirPath = "File_Handling/data";
        String filePath = dirPath + "/sample.txt";
        try {
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.newLine();
                writer.write("Appended using java.io package");
                System.out.println("Data appended successfully (IO)");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendToFileNIO() {
        try {
            Path path = Paths.get("File_Handling", "data", "sample.txt");
            if (Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            Files.write(path, "\nAppended using java.nio package".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Data Appended successfully (NIO)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileIo() {
        String filePath = "File_Handling/data/sample.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exists");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("File read successfully (IO)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileNIO() {
        Path path = Paths.get("File_Handling", "data", "sample.txt");
        if (Files.notExists(path)) {
            System.out.println("File does not Exists...");
            return;
        }
        try {
            Files.lines(path).forEach(System.out::println);
            System.out.println("File read Successfully (NIO)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFileIO(String oldText, String newText) {
        String filePath = "File_Handling/data/sample.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not Found!");
            return;
        }
        try {
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line.replace(oldText, newText));
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
            }
            System.out.println("File updated successfully (IO)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFileNIO(String oldText, String newText) {
        Path path = Paths.get("File_Handling", "data", "sample.txt");
        if (Files.notExists(path)) {
            System.out.println("File not found");
            return;
        }
        try {
            List<String> lines = Files.readAllLines(path);
            List<String> updatedLines = lines.stream().map(line -> line.replace(oldText, newText)).toList();
            Files.write(path, updatedLines, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File Updated Successfully (NIO)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void redirectConsoleToFIle() {
        try {
            String userHome = System.getProperty("user.home");
            File logFile = new File(userHome + "/app-console.log");
            PrintStream ps = new PrintStream(new FileOutputStream(logFile, true));
            System.setOut(ps);
            System.setErr(ps);
            System.out.println("Console redirected to file file");
            System.out.println("This will be written to app-consloe.log");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFileIO() {
        File file = new File("File_Handling/data/sample.txt");
        if (file.exists() && file.delete()) {
            System.out.println("File deleted successfully (IO)");
        } else {
            System.out.println("Unadle to delete a file");
        }
    }

    public static void deleteFileNIO() {
        Path path = Paths.get("File_Handling", "data", "sample.txt");
        try {
            Files.deleteIfExists(path);
            System.out.println("File deleted successfully (NIO)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
