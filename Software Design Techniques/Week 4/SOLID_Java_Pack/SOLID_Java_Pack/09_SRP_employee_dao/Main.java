public class Main {
    public static void main(String[] args) {
        System.out.println("== SRP (Single Responsibility) ==");

        Employee e = new Employee("E-100", "Ada");
        e.doWork();

        EmployeeRepository repo = new EmployeeRepository(new FakeDbConnection());
        repo.saveEmployee(e);
        repo.deleteEmployee(e);
    }
}
