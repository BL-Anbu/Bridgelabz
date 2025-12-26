package Day_23_Practice_Problem;

import java.util.Scanner;

public class UserRegistration {

    static UserValidation firstName = value -> value.matches("^[A-Z][a-z]{2,}$");
    static UserValidation lastName = value -> value.matches("^[A-Z][a-z]{2,}$");
    static UserValidation emailId = value -> value.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:\\.[a-zA-Z]{2,})*$");
    static UserValidation mobile = phone -> phone.matches("^[6-9][0-9]{9}$");
    static UserValidation password = checkPassword -> checkPassword.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");


    public static void main(String[] args) {
        System.out.println("Enter firstName :");
        Scanner sc = new Scanner(System.in);
        String fName = sc.nextLine();

        System.out.println("Enter lastName :");
        String lName = sc.nextLine();

        System.out.println("Enter Email :");;
        String checkEmail = sc.nextLine();

        System.out.println("Enter Mobile :");
        String checkMobile = sc.nextLine();

        System.out.println("Enter Password :");
        String checkPassword = sc.nextLine();

        System.out.println("First Name Valid :" + firstName.validate(fName));
        System.out.println("Last Name Valid :" + lastName.validate(lName));
        System.out.println("Email valid :" + emailId.validate(checkEmail));;
        System.out.println("Mobile valid :" + mobile.validate(checkMobile));
        System.out.println("Password valid :" + password.validate(checkPassword));
    }

}
