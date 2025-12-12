package Java_8_Features.Functional_Interface;

@FunctionalInterface
public interface MyBinaryOperator<T> {
    T apply(T a, T b);
}
