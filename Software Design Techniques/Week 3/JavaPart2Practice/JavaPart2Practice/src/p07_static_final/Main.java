package p07_static_final;

public class Main {
    public static void main(String[] args) {
        StudentCounter a = new StudentCounter("A");
        StudentCounter b = new StudentCounter("B");

        System.out.println("Created: " + a.getName() + ", " + b.getName());
        System.out.println("StudentCounter.getCount(): " + StudentCounter.getCount());

        // Mark a method as final in a base class and show it cannot be overridden.
        //demo'd in childStudent.java
    }
}

