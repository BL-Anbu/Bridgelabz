package Java_8_Features.Functional_Interface;

/*  Functional Interface
 *      > A Functional Interface is an interface that contains exactly one abstract method.
 *      > It can have any number of default or static methods, but only one abstract method.
 *      > It is also called a SAM Interface (Single Abstract Method).
 *      > It is used to represent a single functionality.
 *      > It is the core requirement for using lambda expressions.
 *      > You can optionally annotate it using @FunctionalInterface to ensure only one abstract method exists.
 */

/*  Lambda Expression
 *       > A Lambda Expression is a short block of code that provides an implementation for
 *         a functional interface’s single abstract method, without writing a separate class.
 *       > Introduced in Java 8.
 *       > Allows you to write clean, concise, function-like code.
 *       > Treats functions as first-class values (you can pass them like variables).
 *       > Helps avoid anonymous inner classes.
 */

//    REFERENCE LINK : https://chatgpt.com/share/69390da7-5450-8002-90e1-d4c70dea8229

@FunctionalInterface
public interface MyOperation {
    int apply(int a, int b);
}