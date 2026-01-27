package com.designtechniques.part1.runner;

/**
 * Entry point that lets you run each "step" demo from the command line.
 *
 * Examples:
 *   mvn -q test
 *   mvn -q exec:java -Dexec.mainClass=com.designtechniques.part1.runner.MainRunner -Dexec.args=step01
 */
public final class MainRunner {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Provide a step id (step01..step09). Example: step03");
            return;
        }

        String step = args[0].trim().toLowerCase();
        switch (step) {
            case "step01" -> com.designtechniques.part1.step01_hello.HelloJavaDemo.run();
            case "step02" -> com.designtechniques.part1.step02_basics.BasicsDemo.run();
            case "step03" -> com.designtechniques.part1.step03_controlflow.ControlFlowDemo.run();
            case "step04" -> com.designtechniques.part1.step04_classes_objects.ClassesObjectsDemo.run();
            case "step05" -> com.designtechniques.part1.step05_this_super.ThisSuperDemo.run();
            case "step06" -> com.designtechniques.part1.step06_inheritance.InheritanceDemo.run();
            case "step07" -> com.designtechniques.part1.step07_object_class.ObjectClassDemo.run();
            case "step08" -> com.designtechniques.part1.step08_packages_access.PackagesAccessDemo.run();
            case "step09" -> com.designtechniques.part1.step09_strings.StringsDemo.run();
            default -> System.out.println("Unknown step: " + step + ". Use step01..step09.");
        }
    }
}
