package exam.iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Aggregate object that stores tasks and exposes custom iteration behaviour.
 */
public class TaskList implements Iterable<Task> {
    /** Internal ordered storage of tasks. */
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Adds a task to the collection.
     *
     * @param task task to add
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Exposes the internal task list to the custom iterator implementation.
     *
     * @return internal list of tasks
     */
    public List<Task> getInternalTasks() {
        return tasks;
    }

    /**
     * Creates an iterator for the stored tasks.
     *
     * @return iterator over tasks in insertion order
     */
    @Override
    public Iterator<Task> iterator() {
        return new TaskListIterator(tasks);
    }
}
