package exam.app;

import exam.composite.SimpleTask;
import exam.composite.TaskGroup;
import exam.config.TaskAppConfig;
import exam.factory.PersonalTaskToolkitFactory;
import exam.factory.TaskToolkitFactory;
import exam.factory.TeamTaskToolkitFactory;
import exam.iteration.Task;
import exam.iteration.TaskList;
import exam.observer.ActivityLogObserver;
import exam.observer.PendingCountObserver;
import exam.observer.TaskBoard;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Incremental self-check runner for the programming-section exam pack.
 * Students should run this class while they work. Each exercise prints local
 * feedback showing which checks currently pass and which still need work.
 * 
 * The goal of this runner is to make progress visible during the exam without
 * revealing full solutions directly inside the checking logic.
 */
public class Main {

    /** Number of checks that have passed so far. */
    private static int passedChecks = 0;

    /** Number of checks executed so far. */
    private static int totalChecks = 0;

    /** Approximate running score based on the built-in local rubric. */
    private static double score = 0.0;

    /**
     * Entry point for the self-check runner.
     *
     * @param args command-line arguments; not used by this pack
     */
    public static void main(String[] args) {
        System.out.println("CSCN72040 Final Exam - Programming Section Self-Check");
        System.out.println("Run this file while you work. Each exercise gives incremental feedback.");
        System.out.println("Do not rename required classes, methods, or expected output formats.");
        System.out.println("--------------------------------------------------------------");

        exercise1Singleton();
        exercise2AbstractFactory();
        exercise3Iterator();
        exercise4Observer();
        exercise5CompositeLeaf();

        System.out.println("==============================================================");
        System.out.printf("Checks passed: %d / %d%n", passedChecks, totalChecks);
        System.out.printf("Approximate pack score: %.1f / 100.0%n", score);
        System.out.println("Reminder: this runner gives guidance, but final grading is done on the submitted code.");
    }

    /**
     * Runs the checks for Exercise 1.
     * This exercise evaluates whether the shared configuration object was
     * turned into a proper Singleton.
     */
    private static void exercise1Singleton() {
        header("Exercise 1 - Singleton (15 points)");
        double local = 0;
        try {
            TaskAppConfig c1 = TaskAppConfig.getInstance();
            TaskAppConfig c2 = TaskAppConfig.getInstance();

            local += check("getInstance returns same reference", c1 == c2, 8);

            Constructor<?>[] constructors = TaskAppConfig.class.getDeclaredConstructors();
            boolean privateCtor = constructors.length == 1 && Modifier.isPrivate(constructors[0].getModifiers());
            local += check("constructor is private", privateCtor, 4);

            boolean defaultsOk = c1 != null
                    && "TaskMaster".equals(c1.getAppName())
                    && c1.getMaxTasks() == 100;
            local += check("default config values are correct", defaultsOk, 3);
        } catch (Throwable t) {
            failWithException(t);
        }

        score += local;
        System.out.printf("Exercise 1 subtotal: %.1f / 15%n%n", local);
    }

    /**
     * Runs the checks for Exercise 2.
     * This exercise checks whether the concrete factories create the correct
     * families of related products and whether each product returns the required
     * formatted output.
     */
    private static void exercise2AbstractFactory() {
        header("Exercise 2 - Abstract Factory (25 points)");
        double local = 0;
        try {
            TaskToolkitFactory personalFactory = new PersonalTaskToolkitFactory();
            TaskToolkitFactory teamFactory = new TeamTaskToolkitFactory();

            boolean personalProducts = personalFactory.createTaskFormatter() != null
                    && personalFactory.createReminderMessage() != null;
            local += check("personal factory creates both related products", personalProducts, 4);

            boolean teamProducts = teamFactory.createTaskFormatter() != null
                    && teamFactory.createReminderMessage() != null;
            local += check("team factory creates both related products", teamProducts, 4);

            String personalTitle = personalFactory.createTaskFormatter().formatTitle("Buy milk");
            local += check("personal formatter output", "[PERSONAL] Buy milk".equals(personalTitle), 5);

            String teamTitle = teamFactory.createTaskFormatter().formatTitle("Sprint Plan");
            local += check("team formatter output", "[TEAM] Sprint Plan".equals(teamTitle), 5);

            String personalReminder = personalFactory.createReminderMessage().buildMessage("Alex");
            local += check(
                    "personal reminder output",
                    "Reminder for Alex: review your personal tasks.".equals(personalReminder),
                    3.5
            );

            String teamReminder = teamFactory.createReminderMessage().buildMessage("Jordan");
            local += check(
                    "team reminder output",
                    "Team reminder for Jordan: check shared tasks.".equals(teamReminder),
                    3.5
            );
        } catch (Throwable t) {
            failWithException(t);
        }

        score += local;
        System.out.printf("Exercise 2 subtotal: %.1f / 25%n%n", local);
    }

    /**
     * Runs the checks for Exercise 3.
     * This exercise checks custom iterator behaviour, including visit order
     * and stopping behaviour once all tasks have been traversed.
     */
    private static void exercise3Iterator() {
        header("Exercise 3 - Iterator (20 points)");
        double local = 0;
        try {
            TaskList list = new TaskList();
            list.addTask(new Task("Plan"));
            list.addTask(new Task("Build"));
            list.addTask(new Task("Review"));

            Iterator<Task> iterator = list.iterator();
            List<String> titles = new ArrayList<>();

            while (iterator.hasNext()) {
                titles.add(iterator.next().getTitle());
            }

            local += check("iterator visits all tasks", titles.size() == 3, 6);
            local += check("iterator preserves order", titles.equals(List.of("Plan", "Build", "Review")), 8);
            local += check("iterator eventually stops", !iterator.hasNext(), 6);
        } catch (Throwable t) {
            failWithException(t);
        }

        score += local;
        System.out.printf("Exercise 3 subtotal: %.1f / 20%n%n", local);
    }

    /**
     * Runs the checks for Exercise 4.
     * This exercise checks whether observers are attached correctly and
     * whether board changes produce the required event messages.
     */
    private static void exercise4Observer() {
        header("Exercise 4 - Observer (20 points)");
        double local = 0;
        try {
            TaskBoard board = new TaskBoard();
            ActivityLogObserver logObserver = new ActivityLogObserver();
            PendingCountObserver countObserver = new PendingCountObserver();

            board.addObserver(logObserver);
            board.addObserver(countObserver);

            board.addTask("Write tests");
            board.addTask("Fix bug");
            board.completeTask("Write tests");

            local += check("board tracks remaining open tasks", board.getOpenTaskCount() == 1, 5);
            local += check("activity observer receives three events", logObserver.getReceivedEvents().size() == 3, 5);
            local += check(
                    "first event format is correct",
                    !logObserver.getReceivedEvents().isEmpty()
                            && "ADDED:Write tests".equals(logObserver.getReceivedEvents().get(0)),
                    5
            );
            local += check("pending-count observer updates correctly", countObserver.getPendingCount() == 1, 5);
        } catch (Throwable t) {
            failWithException(t);
        }

        score += local;
        System.out.printf("Exercise 4 subtotal: %.1f / 20%n%n", local);
    }

    /**
     * Runs the checks for Exercise 5.
     * The composite side is already implemented. This exercise verifies the
     * missing leaf behaviour only.
     */
    private static void exercise5CompositeLeaf() {
        header("Exercise 5 - Composite (leaf only) (20 points)");
        double local = 0;
        try {
            TaskGroup course = new TaskGroup("Final Exam Project");
            TaskGroup week1 = new TaskGroup("Week 1");
            TaskGroup week2 = new TaskGroup("Week 2");

            SimpleTask t1 = new SimpleTask("Design classes", 3);
            SimpleTask t2 = new SimpleTask("Write tests", 4);
            SimpleTask t3 = new SimpleTask("Refactor output", 2);

            week1.add(t1);
            week1.add(t2);
            week2.add(t3);
            course.add(week1);
            course.add(week2);

            local += check("leaf getName works", "Design classes".equals(t1.getName()), 4);
            local += check("leaf getEstimatedHours works", t2.getEstimatedHours() == 4, 4);
            local += check("leaf display format is correct", "  - Write tests (4h)".equals(t2.display("  ")), 5);
            local += check("composite aggregates leaf hours correctly", course.getEstimatedHours() == 9, 7);
        } catch (Throwable t) {
            failWithException(t);
        }

        score += local;
        System.out.printf("Exercise 5 subtotal: %.1f / 20%n%n", local);
    }

    /**
     * Prints a visible section header to keep the runner output organized.
     *
     * @param title title to print for the current exercise
     */
    private static void header(String title) {
        System.out.println();
        System.out.println(title);
        System.out.println("--------------------------------------------------------------");
    }

    /**
     * Records the result of one local check.
     *
     * @param description short human-readable description of the check
     * @param passed whether the check passed
     * @param points points assigned to the check if it passes
     * @return awarded points for that single check
     */
    private static double check(String description, boolean passed, double points) {
        totalChecks++;

        if (passed) {
            passedChecks++;
            System.out.printf("[PASS] %s (+%.1f)%n", description, points);
            return points;
        }

        System.out.printf("[FAIL] %s (+0.0)%n", description);
        return 0.0;
    }

    /**
     * Prints a simple error line when an exception prevents an exercise from
     * being checked normally.
     *
     * @param t exception thrown while executing a local exercise check
     */
    private static void failWithException(Throwable t) {
        System.out.println(
                "[ERROR] Exception while running this exercise: "
                        + t.getClass().getSimpleName()
                        + " - "
                        + t.getMessage()
        );
    }
}
