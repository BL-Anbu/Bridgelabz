package Java_8_Features.Method_Reference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodReference {

//1️⃣ Static Method → ClassName::staticMethod
//2️⃣ Instance Method (Object) → object::method
//3️⃣ Instance Method (Class) → ClassName::method
//4️⃣ Constructor → ClassName::new
    public static void main(String[] args) {

        BinaryOperator<Integer> op = Calculator::add;
        System.out.println(op.apply(10, 20));


        Printer printer = new Printer();
        Consumer<String> c = printer::print;
        c.accept("Hello");

        Comparator<String> cmp = String::compareToIgnoreCase;

        Supplier<List<String>> supplier = ArrayList::new;
        List<String> list = supplier.get();

    }
}
class Calculator {
    static int add(int a, int b) {
        return a + b;
    }
}
class Printer {

    void print(String message) {
        System.out.println("Printing: " + message);
    }
}