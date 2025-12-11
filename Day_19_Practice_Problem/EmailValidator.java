package Day_19_Practice_Problem;

import java.util.regex.Pattern;

public class EmailValidator {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,}){1,2}$");

    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("abc@yahoo.com")); // true
        System.out.println(isValidEmail("abc@.com.my"));   // false
        System.out.println(isValidEmail("abc+100@gmail.com")); // true
        System.out.println(isValidEmail("abc@gmail.com.aa.au")); // false
    }
}
