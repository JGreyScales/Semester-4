package com.designtechniques.part1.step08_packages_access;

import com.designtechniques.part1.step08_packages_access.client.ExternalAuditor;
import com.designtechniques.part1.step08_packages_access.client.StudentPortalAccount;
import com.designtechniques.part1.step08_packages_access.school.SchoolAccount;

/**
 * Step 08: Java packages and access modifiers.
 */
public final class PackagesAccessDemo {
    private PackagesAccessDemo() {}

    public static void run() {
        SchoolAccount base = new SchoolAccount();
        ExternalAuditor auditor = new ExternalAuditor();
        StudentPortalAccount portal = new StudentPortalAccount();

        System.out.println("Public: " + auditor.readPublic(base));
        System.out.println("Protected via subclass: " + portal.readProtectedNote());
        System.out.println("Private available inside class only: " + base.revealSecretToSelf());

        System.out.println("Exercise: draw the access table and test what compiles.");
    }
}
