package exam.iteration;

/**
 * Simple domain object used by the iterator exercise.
 */
public class Task {
    /** Human-readable task title. */
    private final String title;

    /**
     * Creates a task with the given title.
     *
     * @param title task title
     */
    public Task(String title) {
        this.title = title;
    }

    /**
     * Gets the task title.
     *
     * @return task title
     */
    public String getTitle() {
        return title;
    }
}
