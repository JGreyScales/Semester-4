public class FakeDbConnection implements DbConnection {
    @Override
    public void execute(String sql) {
        System.out.println("[DB] " + sql);
    }
}
