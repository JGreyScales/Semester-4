package exam.composite;

/**
 * Common component interface for both leaf and composite task nodes.
 */
public interface TaskComponent {
    /**
     * Gets the display name of this task component.
     *
     * @return component name
     */
    String getName();

    /**
     * Gets the total estimated hours for this component.
     *
     * @return estimated hour count
     */
    int getEstimatedHours();

    /**
     * Builds a display string using the provided indentation prefix.
     *
     * @param indent indentation prefix to prepend
     * @return formatted display string
     */
    String display(String indent);
}
