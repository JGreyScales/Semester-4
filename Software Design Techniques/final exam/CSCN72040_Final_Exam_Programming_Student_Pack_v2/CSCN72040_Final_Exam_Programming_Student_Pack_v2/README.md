# CSCN72040 Final Exam - Programming Section Student Pack

## Overview

This programming section is designed to be completed in up to 90 minutes using your own IDE.
You will receive a runnable `Main.java` self-checker. As you complete each exercise, run `Main`
to see which checks are currently passing.

This pack focuses on design patterns and design-quality thinking. The exercises target:

1. Singleton
2. Abstract Factory
3. Iterator
4. Observer
5. Composite

The self-checker gives incremental feedback, but final grading is based on the code you submit.

## Important Rules

- Work only inside this provided exam pack.
- Do **not** rename classes, methods, constructors, packages, or public interfaces already used by `Main.java`.
- Do **not** change the expected output strings that `Main.java` checks.
- You may add private helper methods if needed.
- Use only standard Java. No external libraries or frameworks.

## How the Pack Is Organized

The source code is grouped into folders/packages so related classes stay together:

- `exam.app`
  Contains the runnable `Main` self-checker.

- `exam.config`
  Exercise 1: Singleton.

- `exam.factory`
  Exercise 2: Abstract Factory and related abstract/concrete products.

- `exam.iteration`
  Exercise 3: Iterator.

- `exam.observer`
  Exercise 4: Observer.

- `exam.composite`
  Exercise 5: Composite, where only the leaf class must be completed.

## Exercise Summary

### Exercise 1 - Singleton (15 points)
Complete `exam.config.TaskAppConfig`.

Requirements:
- Make the constructor private.
- Implement `public static TaskAppConfig getInstance()`.
- Keep default values:
  - `appName = "TaskMaster"`
  - `maxTasks = 100`
- Do not rename `getAppName()` or `getMaxTasks()`.

### Exercise 2 - Abstract Factory (25 points)
Complete these classes in `exam.factory`:
- `PersonalTaskFormatter`
- `TeamTaskFormatter`
- `PersonalReminderMessage`
- `TeamReminderMessage`
- `PersonalTaskToolkitFactory`
- `TeamTaskToolkitFactory`

Required output:
- `PersonalTaskFormatter.formatTitle("Buy milk")` -> `[PERSONAL] Buy milk`
- `TeamTaskFormatter.formatTitle("Sprint Plan")` -> `[TEAM] Sprint Plan`
- `PersonalReminderMessage.buildMessage("Alex")` -> `Reminder for Alex: review your personal tasks.`
- `TeamReminderMessage.buildMessage("Jordan")` -> `Team reminder for Jordan: check shared tasks.`

### Exercise 3 - Iterator (20 points)
Complete `exam.iteration.TaskListIterator`.

Requirements:
- `hasNext()` returns `true` while tasks remain.
- `next()` returns the current task and then advances.
- Traversal order must match insertion order.

### Exercise 4 - Observer (20 points)
Complete:
- `exam.observer.TaskBoard`
- `exam.observer.PendingCountObserver`

Requirements:
- `addTask(String taskName)` adds the task and notifies observers with `ADDED:<taskName>`
- `completeTask(String taskName)` removes the task if present and notifies observers with `COMPLETED:<taskName>`
- `PendingCountObserver.update(String eventMessage)` increments on `ADDED:` and decrements on `COMPLETED:`

### Exercise 5 - Composite (leaf only) (20 points)
Complete `exam.composite.SimpleTask`.

Requirements:
- `getName()` returns the leaf task name.
- `getEstimatedHours()` returns the stored hour value.
- `display(String indent)` returns exact format:
  `<indent>- <name> (<hours>h)`

Only the leaf must be completed. The composite class is already implemented.

## How to Run in Eclipse

1. Unzip the pack.
2. Open Eclipse.
3. Select **File > Open Projects from File System...**
4. Choose the unzipped project folder.
5. Let Eclipse build the project.
6. Open `src/exam/app/Main.java`.
7. Run it as a Java application.

If Eclipse does not detect the structure automatically, create a new Java project and copy the `src`
folder contents into it.

## How to Run in VS Code

1. Unzip the pack.
2. Open VS Code.
3. Select **File > Open Folder** and choose the unzipped folder.
4. Ensure Java extensions are installed.
5. Open `src/exam/app/Main.java`.
6. Use the Run command above `main`, or run from the Java explorer.

## Command-Line Helpers

Two helper scripts are included:

- `run.bat` for Windows
- `run.sh` for macOS/Linux

They compile all `.java` files into `bin` and run `exam.app.Main`.

## How Incremental Feedback Works

`Main.java` contains automated checks for each exercise. Some exercises have multiple local checks.
That means partially correct work may still pass some checks before the whole exercise is finished.

Be careful:
- exact output text matters
- exact method names matter
- required return values matter

## Design Advice

Before you code, identify the role of the class you are editing.

Examples:
- Singleton shared configuration object
- Abstract product
- Concrete product
- Concrete factory
- Iterator
- Subject
- Observer
- Component
- Composite
- Leaf

A common exam mistake is changing names because a different naming style feels clearer.
Do not do that here. The self-checker depends on the provided names.

Another common mistake is overcoding. Keep the solution small, direct, and aligned with the expected pattern.

## Submission Reminder

Submit the completed pack exactly as instructed by your professor.
The self-checker is meant to help you while you work, but final grading is based on the submitted code.

Good luck.
