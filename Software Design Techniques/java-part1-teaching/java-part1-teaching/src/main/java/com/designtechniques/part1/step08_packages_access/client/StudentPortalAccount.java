package com.designtechniques.part1.step08_packages_access.client;

import com.designtechniques.part1.step08_packages_access.school.SchoolAccount;

/**
 * Subclass in a different package.
 * Demonstrates what protected members look like across packages.
 */
public class StudentPortalAccount extends SchoolAccount {
    public String readProtectedNote() {
        return protectedNote; // OK (subclass)
    }
}
