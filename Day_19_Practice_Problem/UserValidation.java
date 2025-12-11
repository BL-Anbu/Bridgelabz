package Day_19_Practice_Problem;

import java.util.regex.Pattern;

public class UserValidation {

    // First & Last Name
    public static final Pattern NAME_PATTERN =
            Pattern.compile("^[A-Z][a-zA-Z]{2,}$");

    // Email
    public static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[a-z0-9]+([._+-][a-z0-9]+)?@[a-z0-9]+\\.[a-z]{2,}(\\.[a-z]{2,})?$");

    // Mobile Number
    public static final Pattern MOBILE_PATTERN =
            Pattern.compile("^[0-9]{2} [0-9]{10}$");

    // Password
    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=^[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$).{8,}$");

    public static void main(String[] args) {

        System.out.println(NAME_PATTERN.matcher("Anbu").matches());
        System.out.println(NAME_PATTERN.matcher("Anna").matches());

        System.out.println(EMAIL_PATTERN.matcher("abc.xyz@bl.co.in").matches());
        System.out.println(EMAIL_PATTERN.matcher("abc@bl.co").matches());

        System.out.println(MOBILE_PATTERN.matcher("91 9919819801").matches());

        System.out.println(PASSWORD_PATTERN.matcher("Abcd1234@").matches());
    }
}
