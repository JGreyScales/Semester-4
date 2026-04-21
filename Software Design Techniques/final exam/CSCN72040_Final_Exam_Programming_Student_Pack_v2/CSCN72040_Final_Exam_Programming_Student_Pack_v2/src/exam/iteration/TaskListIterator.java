package exam.iteration;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Custom iterator used by the task-list collection.
 */
public class TaskListIterator implements Iterator<Task> {
    /** Tasks being traversed. */
    private final List<Task> tasks;

    /** Current iterator position. */
    private int index = 0;

    /**
     * Creates an iterator over the supplied task list.
     *
     * @param tasks tasks to traverse
     */
    public TaskListIterator(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Indicates whether another task is available.
     * TODO Exercise 3:
     * Return true while there are still tasks remaining.
     *
     * @return true if another task exists; otherwise false
     */
    @Override
    public boolean hasNext() {
        return this.tasks.size() > this.index + 1;
    }

    /**
     * Returns the current task and then advances the iterator.
     * TODO Exercise 3:
     * Return the next task and then move forward.
     *
     * @return next task in traversal order
     * @throws NoSuchElementException if no tasks remain
     */
    @Override
    public Task next() {
        if (this.hasNext()){
            Task returnValue = this.tasks.get(index);
            this.index = this.index + 1;
            return returnValue;
        } else {
            throw new NoSuchElementException("No more items can be retrieved");
        }
    }
}
