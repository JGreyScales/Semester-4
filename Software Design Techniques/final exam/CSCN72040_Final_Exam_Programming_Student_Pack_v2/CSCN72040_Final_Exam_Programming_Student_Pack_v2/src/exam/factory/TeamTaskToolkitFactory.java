package exam.factory;

/**
 * Concrete factory for the team-task product family.
 */
public class TeamTaskToolkitFactory implements TaskToolkitFactory {
    /**
     * Creates the formatter belonging to the team-task family.
     * TODO Exercise 2:
     * Return the team formatter product.
     *
     * @return team task formatter
     */
    @Override
    public TaskFormatter createTaskFormatter() {
        return new TeamTaskFormatter();
    }

    /**
     * Creates the reminder-message product belonging to the team-task family.
     * TODO Exercise 2:
     * Return the team reminder product.
     *
     * @return team reminder-message product
     */
    @Override
    public ReminderMessage createReminderMessage() {
        return new TeamReminderMessage();
    }
}
