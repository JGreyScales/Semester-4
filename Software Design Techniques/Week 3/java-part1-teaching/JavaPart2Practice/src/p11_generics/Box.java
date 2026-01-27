package p11_generics;

/**
 * Generic container class.
 */
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() { return value; }
    public void setValue(T value) { this.value = value; }

    @Override
    public String toString() {
        return "Box{value=" + value + "}";
    }

    // TODO: EXERCISE 1
    // Add a method <U> boolean hasSameValue(Box<U> other) that compares string representations.
}
