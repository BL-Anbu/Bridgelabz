package Java_8_Features.Functional_Interface;

public class FIMain {


    /*
    Main Purpose of Creating Built-In Functional Interfaces
            1. To Support Lambda Expressions
            2. To Avoid Creating New Interfaces Again and Again

            3. To Make Stream API Work Smoothly
                    Stream.filter() → Predicate
                    Stream.map() → Function
                    Stream.forEach() → Consumer
                    Stream.generate() → Supplier
                    Stream.sorted() → Comparator

            4. To Standardize Common Functional Patterns
                    Pattern	                            Example	                Interface
                    Takes input, returns boolean	    filtering	            Predicate
                    Takes input, returns output	        mapping	                Function
                    Takes input, returns nothing	    printing	            Consumer
                    Takes no input, returns something	object creation	        Supplier

            5. To Reduce Boilerplate Code
            6. To Improve Performance Using invokedynamic
            7. To Promote Functional Programming in Java

Predicate

→ Used for conditions, filtering, validations.

Function

→ Used for transforming values, mapping.

Consumer

→ Used for performing actions, printing, logging.

Supplier

→ Used for generating values, object creation.

Runnable

→ Used for threads without return value.

Callable

→ Used for threads that return values.

*/

//    public static void main(String[] args) {

    /// /        MyOperation add = Integer::sum;
//        MyOperation add = (a,b)-> a+b;
//        MyOperation subract = (a,b)-> a-b;
//        MyOperation division = (a,b)-> a/b;
//        MyOperation multiplication = (a,b)-> a*b;
//
//        int result1=add.apply(1,2);
//        int result2=subract.apply(1,2);
//        int result3=division.apply(1,2);
//        int result4=multiplication.apply(1,2);
//
//        System.out.println("Addition : "+result1);
//        System.out.println("Subraction : "+result2);
//        System.out.println("Division : "+result3);
//        System.out.println("Multiplication : "+result4);
//
//    }
    public static void main(String[] args) throws Exception {

        System.out.println("===== Testing MyOperation (Custom BinaryOperator) =====");

        MyOperation add = (a, b) -> a + b;
        MyOperation subtract = (a, b) -> a - b;
        MyOperation multiply = (a, b) -> a * b;
        MyOperation division = (a, b) -> a / b;

        System.out.println("Add: " + add.apply(10, 5));
        System.out.println("Subtract: " + subtract.apply(10, 5));
        System.out.println("Multiply: " + multiply.apply(10, 5));
        System.out.println("Division: " + division.apply(10, 5));


        System.out.println("\n===== Testing MyPredicate =====");

        MyPredicate<Integer> isEven = (n) -> n % 2 == 0;
        MyPredicate<String> isLongString = (s) -> s.length() > 5;

        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 'HelloWorld' long? " + isLongString.test("HelloWorld"));


        System.out.println("\n===== Testing MyFunction =====");

        MyFunction<String, Integer> stringLength = (s) -> s.length();
        MyFunction<Integer, Integer> square = (n) -> n * n;

        System.out.println("Length of 'Java': " + stringLength.apply("Java"));
        System.out.println("Square of 7: " + square.apply(7));


        System.out.println("\n===== Testing MyConsumer =====");

        MyConsumer<String> printMessage = (msg) -> System.out.println("Message: " + msg);
        MyConsumer<Integer> printNumber = (n) -> System.out.println("Number: " + n);

        printMessage.accept("Hello Functional Interface!");
        printNumber.accept(999);


        System.out.println("\n===== Testing MySupplier =====");

        MySupplier<Double> randomValue = Math::random;
        MySupplier<String> greet = () -> "Welcome to Java 8!";

        System.out.println("Random Value: " + randomValue.get());
        System.out.println("Greeting: " + greet.get());


        System.out.println("\n===== Testing MyRunnable =====");

        MyRunnable task1 = () -> System.out.println("Running MyRunnable Task...");
        task1.run();

        System.out.println("\n===== Testing MyCallable =====");

        MyCallable<Integer> getNumber = () -> 100;
        MyCallable<String> getData = () -> "Callable Result";

        System.out.println("Callable Number: " + getNumber.call());
        System.out.println("Callable String: " + getData.call());


        System.out.println("\n===== ALL TESTS COMPLETED SUCCESSFULLY =====");
    }
}
