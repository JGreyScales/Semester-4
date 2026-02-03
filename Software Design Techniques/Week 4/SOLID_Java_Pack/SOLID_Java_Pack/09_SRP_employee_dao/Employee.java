public class Employee {
    private final String id;
    private final String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void doWork() {
        System.out.println(name + " is working...");
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
