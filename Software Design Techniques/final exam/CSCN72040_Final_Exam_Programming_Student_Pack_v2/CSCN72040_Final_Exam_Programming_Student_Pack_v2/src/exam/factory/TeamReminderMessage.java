package exam.factory;

/**
 * Concrete reminder-message product for the team-task family.
 */
public class TeamReminderMessage implements ReminderMessage {
    /**
     * Builds a team reminder message.
     * TODO Exercise 2:
     * Format like: Team reminder for Jordan: check shared tasks.
     *
     * @param assignee assignee name
     * @return reminder message text
     */
    @Override
    public String buildMessage(String assignee) {
        return "Team reminder for " + assignee + ": check shared tasks.";
    }
}
