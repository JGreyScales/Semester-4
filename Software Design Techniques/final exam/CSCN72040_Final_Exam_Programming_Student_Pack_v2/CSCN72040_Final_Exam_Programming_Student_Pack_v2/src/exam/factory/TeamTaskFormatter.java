package exam.factory;

/**
 * Concrete formatter for the team-task product family.
 */
public class TeamTaskFormatter implements TaskFormatter {
    /**
     * Formats the incoming title for the team-task family.
     * TODO Exercise 2:
     * Format like: [TEAM] Sprint Plan
     *
     * @param title raw task title
     * @return formatted title
     */
    @Override
    public String formatTitle(String title) {
        return "[TEAM] " + title;
    }
}
