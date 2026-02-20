package report;

/**
 * Step 4 requirement:
 * - Use an interface with a default method.
 */
public interface ReportFormatter<T> {

    String format(T model);

    default void printToConsole(String text) {
        System.out.println(text);
    }
}
