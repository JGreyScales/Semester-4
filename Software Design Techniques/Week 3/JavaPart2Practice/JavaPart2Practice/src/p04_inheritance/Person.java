package p04_inheritance;

public class Person {
    protected String name; // visible to subclasses
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("I am " + name + ", age " + age);
    }

    public void study() {
        System.out.println(name + " is studying (Person version).");
    }
}

