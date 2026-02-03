public class EmployeeRepository {
    private final DbConnection db;

    public EmployeeRepository(DbConnection db) {
        this.db = db;
    }

    public void saveEmployee(Employee e) {
        db.execute("INSERT INTO employee(id,name) VALUES('" + e.getId() + "','" + e.getName() + "')");
    }

    public void deleteEmployee(Employee e) {
        db.execute("DELETE FROM employee WHERE id='" + e.getId() + "'");
    }
}
