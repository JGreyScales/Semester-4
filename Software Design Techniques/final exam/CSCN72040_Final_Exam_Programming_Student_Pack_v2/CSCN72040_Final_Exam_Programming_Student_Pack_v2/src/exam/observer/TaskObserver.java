package exam.observer;

/**
 * Observer abstraction for task-board change notifications.
 */
public interface TaskObserver {
    /**
     * Receives a task-board event message.
     *
     * @param eventMessage event text such as ADDED:TaskName
     */
    void update(String eventMessage);
}
