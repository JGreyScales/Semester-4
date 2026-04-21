package exam.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite node that can contain other task components.
 */
public class TaskGroup implements TaskComponent {
    /** Name of the group. */
    private final String name;

    /** Child components belonging to this group. */
    private final List<TaskComponent> children = new ArrayList<>();

    /**
     * Creates a task group with the given name.
     *
     * @param name group name
     */
    public TaskGroup(String name) {
        this.name = name;
    }

    /**
     * Adds a child component to this group.
     *
     * @param component child component to add
     */
    public void add(TaskComponent component) {
        children.add(component);
    }

    /**
     * Gets the group name.
     *
     * @return group name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sums the estimated hours from all child components.
     *
     * @return total estimated hours of all children
     */
    @Override
    public int getEstimatedHours() {
        int total = 0;
        for (TaskComponent child : children) {
            total += child.getEstimatedHours();
        }
        return total;
    }

    /**
     * Builds a display string for this group and all of its children.
     *
     * @param indent indentation prefix
     * @return formatted display string
     */
    @Override
    public String display(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent)
                .append("+ ")
                .append(name)
                .append(" (")
                .append(getEstimatedHours())
                .append("h)");
        for (TaskComponent child : children) {
            sb.append(System.lineSeparator()).append(child.display(indent + "  "));
        }
        return sb.toString();
    }
}
