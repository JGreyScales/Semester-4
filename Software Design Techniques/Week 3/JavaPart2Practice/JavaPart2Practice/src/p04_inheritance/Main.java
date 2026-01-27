package p04_inheritance;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Alex", 30);
        Student s = new Student("Sam", 20, "S1001");

        p.introduce();
        p.study();

        s.introduce();
        s.study();

        // TODO: EXERCISE 2
        // Store p and s in a Person[] and call study() in a loop to observe polymorphism.
    }
}

