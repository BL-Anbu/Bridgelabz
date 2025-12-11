package Java_8_Features.Functional_Interface;

/*
        Definition
            A functional interface that takes one input and returns a value (can be any type).
        Use Case
            Data transformation
            Converting one type to another
            Mapping operations in Streams
*/
@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T t);
}