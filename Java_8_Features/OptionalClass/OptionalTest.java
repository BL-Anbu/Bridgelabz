package Java_8_Features.OptionalClass;

public class OptionalTest {

    public static void main(String[] args) {

        System.out.println("\n===== ofNullable() =====");
        MyOptional<String> opt2 = MyOptional.ofNullable(null);
        System.out.println(opt2.isPresent());


        System.out.println("\n===== ifPresent() =====");
        MyOptional.of("Hello")
                .ifPresent(v -> System.out.println("Value: " + v));


        System.out.println("\n===== orElse() =====");
        String result1 = opt2.orElse("Default");
        System.out.println(result1);


        System.out.println("\n===== orElseGet() =====");
        String result2 = opt2.orElseGet(() -> "Generated Default");
        System.out.println(result2);


        System.out.println("\n===== filter() =====");
        MyOptional.of("Java")
                .filter(s -> s.length() > 5)
                .ifPresent(s -> System.out.println("Passed Filter"));

        MyOptional.of("Java")
                .filter(s -> s.length() > 5)
                .orElse("Filtered Out");

        System.out.println("\n===== orElseThrow() =====");
        try {
            MyOptional.empty().orElseThrow();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("\n===== ALL OPTIONAL TESTS COMPLETED =====");
    }
}
