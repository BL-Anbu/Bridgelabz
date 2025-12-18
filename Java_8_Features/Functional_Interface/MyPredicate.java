package Java_8_Features.Functional_Interface;

/*
        Definition
            A functional interface that takes one input and returns a boolean.
        Use Case
            Validations
            Filtering in Streams
            Checking conditions
 */

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
