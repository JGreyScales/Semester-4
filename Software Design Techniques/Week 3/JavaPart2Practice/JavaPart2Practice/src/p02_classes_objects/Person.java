package p02_classes_objects;

/**
 * Demonstrates fields, encapsulation, and getters/setters.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { 
        if (age < 0){
            return;
        }
        this.age = age; 
    }

    public void study() {
        System.out.println(name + " is studying.");
    }
}

