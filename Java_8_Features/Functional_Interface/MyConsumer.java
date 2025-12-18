package Java_8_Features.Functional_Interface;

/*
        Definition
            A functional interface that takes one input and returns nothing (void).
        Use Case
            Printing
            Logging
            Storing values
            Operations that do not return anything
*/

@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}

