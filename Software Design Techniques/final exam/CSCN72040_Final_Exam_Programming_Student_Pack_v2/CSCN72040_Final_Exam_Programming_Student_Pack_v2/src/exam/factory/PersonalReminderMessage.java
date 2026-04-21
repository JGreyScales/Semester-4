package exam.factory;

/**
 * Concrete reminder-message product for the personal-task family.
 */
public class PersonalReminderMessage implements ReminderMessage {
    /**
     * Builds a personal reminder message.
     * TODO Exercise 2:
     * Format like: Reminder for Alex: review your personal tasks.
     *
     * @param assignee assignee name
     * @return reminder message text
     */
    @Override
    public String buildMessage(String assignee) {
        return "Reminder for " + assignee + ": review your personal tasks.";
    }
}
