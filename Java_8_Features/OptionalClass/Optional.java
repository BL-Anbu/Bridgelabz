package Java_8_Features.OptionalClass;


class Optional<T> {
    private final T value;   // may be null internally

    Optional(T value) {
        this.value = value;
    }
}
