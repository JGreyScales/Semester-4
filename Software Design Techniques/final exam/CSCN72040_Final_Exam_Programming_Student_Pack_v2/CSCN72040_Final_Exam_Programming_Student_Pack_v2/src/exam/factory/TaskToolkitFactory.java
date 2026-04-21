package exam.factory;

/**
 * Abstract factory for a family of related task-tool products.
 * Each concrete factory must return a matching formatter and reminder
 * message implementation from the same product family.
 */
public interface TaskToolkitFactory {
    /**
     * Creates the task formatter for this product family.
     *
     * @return task formatter
     */
    TaskFormatter createTaskFormatter();

    /**
     * Creates the reminder-message product for this product family.
     *
     * @return reminder-message product
     */
    ReminderMessage createReminderMessage();
}
