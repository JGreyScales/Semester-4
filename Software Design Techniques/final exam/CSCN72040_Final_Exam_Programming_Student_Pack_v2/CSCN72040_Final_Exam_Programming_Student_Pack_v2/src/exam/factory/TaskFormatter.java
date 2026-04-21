package exam.factory;

/**
 * Abstract product representing title-formatting behaviour.
 */
public interface TaskFormatter {
    /**
     * Formats a task title for one specific product family.
     *
     * @param title raw task title
     * @return formatted title
     */
    String formatTitle(String title);
}
