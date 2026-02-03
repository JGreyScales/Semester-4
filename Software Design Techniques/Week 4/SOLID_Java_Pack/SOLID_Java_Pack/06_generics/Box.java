public class Box<T> {
    private T value;
    private Class<T> type;

    public Box(T value, Class<T> type) {
        this.value = value;
        this.type = type;
    }

    public T get() {
        return value;
    }

    public Class<T> getType(){
        return this.type;
    }

    public void set(T value) {
        this.value = value;
    }

    public boolean hasSameTypeAs(Box<?> other){
        return (this.type == other.getType());
    }

    public static <T> void copy(Box<T> from, Box<T> to){
        to.set(from.get());
    }
}
