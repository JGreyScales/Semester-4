package com.designtechniques.part1.step08_packages_access;

/**
 * Package-private helper (no modifier): visible only within the same package.
 */
final class InternalHelper {
    private InternalHelper() {}

    static String format(String prefix, String name) {
        return prefix + " " + name;
    }
}
