package exam.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject in the Observer pattern for the task-board exercise.
 */
public class TaskBoard {
    /** Registered observers. */
    private final List<TaskObserver> observers = new ArrayList<>();

    /** Currently open task names. */
    private final List<String> openTasks = new ArrayList<>();

    /**
     * Registers an observer.
     *
     * @param observer observer to add
     */
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer.
     *
     * @param observer observer to remove
     */
    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    /**
     * Adds a task and notifies observers.
     * TODO Exercise 4:
     * Add the task name to openTasks and notify observers with ADDED:<taskName>
     *
     * @param taskName task to add
     */
    public void addTask(String taskName) {
        for (TaskObserver observer : observers) {
            observer.update("ADDED:" + taskName);
        }
        openTasks.add(taskName);
    }

    /**
     * Completes a task and notifies observers if the task exists.
     * TODO Exercise 4:
     * If the task exists, remove it and notify observers with COMPLETED:<taskName>
     *
     * @param taskName task to complete
     */
    public void completeTask(String taskName) {
        for (TaskObserver observer : observers) {
            observer.update("COMPLETED:" + taskName);
        }

        // I believe this version of remove contains a lookup
        // via string cmp or memory address
        openTasks.remove(taskName);
    }

    /**
     * Sends the given message to all registered observers.
     *
     * @param message board event message
     */
    private void notifyObservers(String message) {
        for (TaskObserver observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Gets the number of still-open tasks.
     *
     * @return open task count
     */
    public int getOpenTaskCount() {
        return openTasks.size();
    }
}
