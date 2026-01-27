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

    public <U> boolean hasSameValue(Box<U> other){
        return (this.toString().equals(other.toString()));
    }
}
