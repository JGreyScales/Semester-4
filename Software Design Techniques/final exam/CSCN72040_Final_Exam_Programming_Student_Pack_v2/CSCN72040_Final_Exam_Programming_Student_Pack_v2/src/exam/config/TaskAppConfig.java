package exam.config;

import exam.iteration.Task;

/**
 * Shared configuration object for the task application.
 * Exercise 1 asks students to turn this class into a proper Singleton so that
 * only one shared configuration instance exists in the system.
 */
public class TaskAppConfig {

    /** Shared Singleton instance. */
    private static TaskAppConfig instance = null;

    /** Application display name used by the self-checker. */
    private String appName;

    /** Maximum task count supported by the app. */
    private int maxTasks;

    /**
     * Creates a new configuration object.
     * TODO Exercise 1:
     * Make this constructor private so callers cannot create many config objects.
     */
    private TaskAppConfig() {
        this.appName = "TaskMaster";
        this.maxTasks = 100;
        TaskAppConfig.instance = this;
    }

    /**
     * Returns the shared configuration object.
     * TODO Exercise 1:
     * Return the same shared object every time.
     *
     * @return shared configuration instance
     */
    public static TaskAppConfig getInstance() {
        if (TaskAppConfig.instance == null){
            new TaskAppConfig();
        }
        return TaskAppConfig.instance;
    }

    /**
     * Gets the application name.
     *
     * @return application name
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Gets the maximum supported task count.
     *
     * @return maximum number of tasks
     */
    public int getMaxTasks() {
        return maxTasks;
    }
}
