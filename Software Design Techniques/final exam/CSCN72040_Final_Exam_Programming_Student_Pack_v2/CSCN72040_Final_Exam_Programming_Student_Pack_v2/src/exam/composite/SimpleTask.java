package exam.composite;

/**
 * Leaf node in the Composite pattern for the task-list manager.
 * Only this class must be completed for Exercise 5. The composite side is
 * already implemented in {@link TaskGroup}.
 */
public class SimpleTask implements TaskComponent {
    /** Task name. */
    private final String name;

    /** Estimated hours for the task. */
    private final int estimatedHours;

    /**
     * Creates a simple task leaf.
     *
     * @param name task name
     * @param estimatedHours estimated hour value
     */
    public SimpleTask(String name, int estimatedHours) {
        this.name = name;
        this.estimatedHours = estimatedHours;
    }

    /**
     * Gets the leaf task name.
     * TODO Exercise 5:
     * Return the task name.
     *
     * @return task name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the stored estimated hour value.
     * TODO Exercise 5:
     * Return the estimated hours stored in the object.
     *
     * @return estimated hours
     */
    @Override
    public int getEstimatedHours() {
        return estimatedHours;
    }

    /**
     * Builds the exact display format required by the self-checker.
     * TODO Exercise 5:
     * Format exactly like: "  - Write tests (3h)"
     * using the incoming indent, task name, and estimated hours.
     *
     * @param indent indentation prefix
     * @return formatted display string
     */
    @Override
    public String display(String indent) {
        return "  - " + name +" ("+ estimatedHours + "h)";
    }
}
