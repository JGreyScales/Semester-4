package exam.factory;

/**
 * Concrete factory for the personal-task product family.
 */
public class PersonalTaskToolkitFactory implements TaskToolkitFactory {
    /**
     * Creates the formatter belonging to the personal-task family.
     * TODO Exercise 2:
     * Return the personal formatter product.
     *
     * @return personal task formatter
     */
    @Override
    public TaskFormatter createTaskFormatter() {
        return new PersonalTaskFormatter();
    }

    /**
     * Creates the reminder-message product belonging to the personal-task family.
     * TODO Exercise 2:
     * Return the personal reminder product.
     *
     * @return personal reminder-message product
     */
    @Override
    public ReminderMessage createReminderMessage() {
        ReminderMessage reminderFormatter = new PersonalReminderMessage();
        return reminderFormatter;
    }
}
