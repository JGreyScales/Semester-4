# Java Programming Part-1 (Teaching Project)

This project mirrors the **outline** from the provided slide deck (Java Programming: Part-1), and organizes the concepts into incremental packages that you can teach week-by-week and turn into small graded tasks.

The main topics covered are: Java program structure and packages, basic concepts (static typing + primitive types), control flow statements, classes and objects, `this` and `super`, inheritance, the `Object` class (with `toString()`), packages + access modifiers, and Java `String` (including the string constant pool).

## Requirements

Java 17+. Maven is optional (recommended for JUnit grading).

## How to run demos

If you just want to run demos without Maven:

1. `chmod +x run_step.sh` (once)
2. `./run_step.sh step03`

If you prefer Maven:



From the project root:

1. `mvn -q test` (tests are disabled by default)
2. Run a specific demo step:

   `mvn -q exec:java -Dexec.mainClass=com.designtechniques.part1.runner.MainRunner -Dexec.args=step03`

Use `step01` through `step09`.

## Step-by-step package map

Each step has a `*Demo` class you can run in class, plus optional `Exercises` you can assign.

### Step 01: Hello Java + packages

Package: `com.designtechniques.part1.step01_hello`

In-class goal: show the relationship between the folder structure and the `package` declaration.

Suggested task: ask students to create a second class in the same package and call it from `HelloJavaDemo.run()`.

### Step 02: Basic concepts (types + defaults)

Package: `com.designtechniques.part1.step02_basics`

In-class goal: emphasize static typing, primitive types, and the difference between field defaults and uninitialized local variables.

Suggested task: implement `step02_basics.Exercises.parseTrimmedInt(...)` and `step02_basics.Exercises.bmi(...)`.

### Step 03: Control flow statements

Package: `com.designtechniques.part1.step03_controlflow`

In-class goal: cover `if/else`, `switch`, `for`, `while`, and `do-while`.

Suggested task: implement `step03_controlflow.Exercises.fizzBuzz(...)` and `step03_controlflow.Exercises.letterGrade(...)`.

### Step 04: Classes and objects

Package: `com.designtechniques.part1.step04_classes_objects`

In-class goal: class structure, encapsulation (private fields), getters/setters, constructors, instantiation with `new`, and method invocation with dot notation.

Suggested task: ask students to add validation (e.g., age cannot be negative) and update `toString()` accordingly.

### Step 05: `this` and `super`

Package: `com.designtechniques.part1.step05_this_super`

In-class goal: constructor chaining with `this(...)` and superclass constructor invocation with `super(...)`.

Suggested task: add another constructor overload in `Professor` and explain which constructor chain gets called.

### Step 06: Inheritance

Package: `com.designtechniques.part1.step06_inheritance`

In-class goal: `extends`, terminology (superclass/subclass), and overriding methods with `@Override`.

Suggested task: extend `Student` with another overridden method and demonstrate polymorphism using a `Person` reference.

### Step 07: The `Object` class

Package: `com.designtechniques.part1.step07_object_class`

In-class goal: why `toString()`, `equals(...)`, and `hashCode()` matter, and what the default `Object.toString()` looks like.

Suggested task: create another domain class (e.g., `Patient`) and implement `equals/hashCode` on an identifier.

### Step 08: Packages + access modifiers

Package: `com.designtechniques.part1.step08_packages_access`

In-class goal: the difference between `public`, `protected`, package-private (no modifier), and `private`, including the cross-package subclass case.

Suggested task: have students uncomment code in `ExternalAuditor.tryReadProtected(...)`, compile, and explain the compiler error in their own words.

### Step 09: Java `String` and the string constant pool

Package: `com.designtechniques.part1.step09_strings`

In-class goal: literals vs `new String(...)`, `==` vs `equals(...)`, and how `intern()` relates to the pool.

Suggested task: implement `step09_strings.Exercises.safeEquals(...)` and discuss why `==` is not correct for string content equality.

## Optional: turning exercises into autograded tasks

JUnit tests are included but disabled by default via `@Disabled(...)`. When you want to grade a step:

1. Remove the `@Disabled` annotation from the matching test file in `src/test/java/com/designtechniques/part1/`.
2. Run `mvn test`.

