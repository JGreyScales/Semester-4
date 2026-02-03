public class ConsoleLogger implements Logger {
    @Override
    public void log(String level, String message) {
        System.out.println("[" + level + "] " + message);
    }
}
