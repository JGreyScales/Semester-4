package exam.factory;

/**
 * Concrete formatter for the personal-task product family.
 */
public class PersonalTaskFormatter implements TaskFormatter {
    /**
     * Formats the incoming title for the personal-task family.
     * TODO Exercise 2:
     * Format like: [PERSONAL] Buy milk
     *
     * @param title raw task title
     * @return formatted title
     */
    @Override
    public String formatTitle(String title) {
        return "[PERSONAL] " + title;
    }
}
