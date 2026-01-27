package p05_object_tostring;

public class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + "}";
    }

    // TODO: EXERCISE 1
    // Override equals(Object o) and hashCode() so two employees with same name+age are equal.
}
