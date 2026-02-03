public interface Logger {
    void log(String level, String message);

    default void info(String message) {
        log("INFO", message);
    }

    default void warn(String message) {
        log("WARN", message);
    }
}
