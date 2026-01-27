package p05_object_tostring;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee("Pedro", 99);
        Employee e1 = new Employee("Pedro", 99);
        Employee e2 = new Employee("Test", 30);
        System.out.println("e == e1: " + e.equals(e1));
        System.out.println("e == e2: " + e.equals(e2));
        System.out.println("e1 == e2: " + e1.equals(e2));
    }
}

