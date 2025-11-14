import java.util.Scanner;

public class VowelConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = Character.toLowerCase(sc.next().charAt(0));

        switch (ch) {
            case 'a', 'e', 'i', 'o', 'u' -> System.out.println(ch + " is a vowel");
            default -> System.out.println(ch + " is a consonant");
        }
        sc.close();
    }
}
