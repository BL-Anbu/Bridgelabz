package Day_19_Practice_Problem;

public class UtilMain {

    public static void main(String[] args) {

        System.out.println(EmailValidator.isValidEmail("abc@yahoo.com"));         // true
        System.out.println(EmailValidator.isValidEmail("abc.100@yahoo.com"));     // true
        System.out.println(EmailValidator.isValidEmail("abc@1.com"));             // true
        System.out.println(EmailValidator.isValidEmail("abc+100@gmail.com"));     // true

        System.out.println(EmailValidator.isValidEmail("abc"));                   // false
        System.out.println(EmailValidator.isValidEmail("abc@.com.my"));           // false
        System.out.println(EmailValidator.isValidEmail("abc123@gmail.a"));        // false
        System.out.println(EmailValidator.isValidEmail("abc.@gmail.com"));        // false
        System.out.println(EmailValidator.isValidEmail("abc..2002@gmail.com"));   // false
        System.out.println(EmailValidator.isValidEmail("abc@gmail.com.1a"));      // false
        System.out.println(EmailValidator.isValidEmail("abc@gmail.com.aa.au"));   // false

        System.out.println(RegexUtil.isAlpha("Hello"));      // true
        System.out.println(RegexUtil.isAlpha("Hello123"));   // false

        System.out.println(RegexUtil.isValidUsername("Anbu_123"));  // true
        System.out.println(RegexUtil.isValidUsername("1Anbu"));     // false (cannot start with digit)
        System.out.println(RegexUtil.isValidUsername("An"));        // false (less than 3 chars)

        System.out.println(RegexUtil.isValidPinCode("600001")); // true
        System.out.println(RegexUtil.isValidPinCode("012345")); // false
        System.out.println(RegexUtil.isValidPinCode("60001"));  // false

        System.out.println(RegexUtil.isValidIP("192.168.1.1"));   // true
        System.out.println(RegexUtil.isValidIP("255.255.255.255")); // true
        System.out.println(RegexUtil.isValidIP("999.999.1.1"));   // false

        System.out.println(RegexUtil.isValidURL("https://google.com"));         // true
        System.out.println(RegexUtil.isValidURL("http://www.example.org/test")); // true
        System.out.println(RegexUtil.isValidURL("htt:/google.com"));            // false

        System.out.println(RegexUtil.isValidDate("24/12/2024"));  // true
        System.out.println(RegexUtil.isValidDate("32/12/2024"));  // false
        System.out.println(RegexUtil.isValidDate("24/13/2024"));  // false

        System.out.println(RegexUtil.isValidTime("23:59"));  // true
        System.out.println(RegexUtil.isValidTime("24:10"));  // false
        System.out.println(RegexUtil.isValidTime("12:60"));  // false

        System.out.println(RegexUtil.isValidPAN("ABCDE1234F")); // true
        System.out.println(RegexUtil.isValidPAN("ABCD1234F"));  // false
        System.out.println(RegexUtil.isValidPAN("ABCDE12345")); // false

        System.out.println(RegexUtil.isValidAadhar("234567890123")); // true
        System.out.println(RegexUtil.isValidAadhar("123456789012")); // false (starts with 1)
        System.out.println(RegexUtil.isValidAadhar("23456"));        // false



    }
}
