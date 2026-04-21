package exam.factory;

/**
 * Abstract product representing reminder-message generation.
 */
public interface ReminderMessage {
    /**
     * Builds a reminder message for the given assignee.
     *
     * @param assignee name of the assignee
     * @return reminder message text
     */
    String buildMessage(String assignee);
}
