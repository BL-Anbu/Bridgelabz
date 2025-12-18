package Java_8_Features.OptionalClass;

import Java_8_Features.Functional_Interface.MyConsumer;
import Java_8_Features.Functional_Interface.MyPredicate;
import Java_8_Features.Functional_Interface.MySupplier;

public final class MyOptional<T> {

    private final T value;

    private MyOptional(T value) {
        this.value = value;
    }

    // like Optional.of()
    public static <T> MyOptional<T> of(T value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        return new MyOptional<>(value);
    }

    // like Optional.ofNullable()
    public static <T> MyOptional<T> ofNullable(T value) {
        return new MyOptional<>(value);
    }

    // like Optional.empty()
    public static <T> MyOptional<T> empty() {
        return new MyOptional<>(null);
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public void ifPresent(MyConsumer<T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }
    public T orElse(T other) {
        return value != null ? value : other;
    }

    public T orElseGet(MySupplier<T> supplier) {
        return value != null ? value : supplier.get();
    }

    public T orElseThrow() {
        if (value == null) {
            throw new RuntimeException("No value present");
        }
        return value;
    }

    public MyOptional<T> filter(MyPredicate<T> predicate) {
        if (value == null || !predicate.test(value)) {
            return MyOptional.empty();
        }
        return this;
    }

}