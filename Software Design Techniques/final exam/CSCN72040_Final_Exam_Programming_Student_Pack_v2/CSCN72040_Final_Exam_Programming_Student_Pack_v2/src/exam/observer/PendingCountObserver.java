package exam.observer;

/**
 * Observer that tracks the number of pending tasks using event messages.
 */
public class PendingCountObserver implements TaskObserver {
    /** Number of currently pending tasks. */
    private int pendingCount = 0;

    /**
     * Updates the pending count from a board event message.
     * TODO Exercise 4:
     * Increase the count for messages that start with ADDED:
     * Decrease the count for messages that start with COMPLETED:
     *
     * @param eventMessage event text sent by the subject
     */
    @Override
    public void update(String eventMessage) {
        if (eventMessage.charAt(0) == 'A'){
            pendingCount++;
        } else {
            pendingCount--;
        }
    }

    /**
     * Gets the current pending-task count.
     *
     * @return pending task count
     */
    public int getPendingCount() {
        return pendingCount;
    }
}
