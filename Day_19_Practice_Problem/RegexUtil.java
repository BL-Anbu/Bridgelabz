package Day_19_Practice_Problem;

public class RegexUtil {

    public static boolean isAlpha(String input) {
        return input.matches("^[A-Za-z]+$");
    }

    public static boolean isAlphaSpace(String input) {
        return input.matches("^[A-Za-z ]+$");
    }

    public static boolean isValidUsername(String input) {
        return input.matches("^[A-Za-z][A-Za-z0-9_]{2,15}$");
    }

    public static boolean isStrongPassword(String input) {
        return input.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }

    public static boolean isValidPinCode(String input) {
        return input.matches("^[1-9][0-9]{5}$");
    }

    public static boolean isValidIP(String input) {
        return input.matches("^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$");
    }

    public static boolean isValidURL(String input) {
        return input.matches("^(https?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/\\S*)?$");
    }

    //    — dd/mm/yyyy
    public static boolean isValidDate(String input) {
        return input.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$");
    }

    public static boolean isValidTime(String input) {
        return input.matches("^([01]\\d|2[0-3]):[0-5]\\d$");
    }

    public static boolean isValidPAN(String input) {
        return input.matches("^[A-Z]{5}[0-9]{4}[A-Z]$");
    }

    public static boolean isValidAadhar(String input) {
        return input.matches("^[2-9][0-9]{11}$");
    }

    public static boolean isValidVehicle(String input) {
        return input.matches("^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$");
    }

    public static boolean isValidUUID(String input) {
        return input.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-5][0-9a-fA-F]{3}-[089abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$");
    }

}
