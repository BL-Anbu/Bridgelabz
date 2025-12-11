package Java_8_Features.Functional_Interface;

/*
       Definition
            A functional interface that takes no input but returns a value.
       Use Case
            Object creation
            Supplying random numbers
            Lazy loading
 */

@FunctionalInterface
public interface MySupplier<R> {
    R get();
}

