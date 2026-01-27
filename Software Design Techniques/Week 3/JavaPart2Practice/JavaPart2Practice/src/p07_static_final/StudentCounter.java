package p07_static_final;

public class StudentCounter {
    private static int count = 0; // belongs to the class, shared across instances
    private final String name;    // cannot be changed once set in constructor

    public StudentCounter(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() { return count; }

    final public String getName() { return name; }

    public static void reset(){
        StudentCounter.count = 0;
    }
}