package com.designtechniques.part1.step08_packages_access.client;

import com.designtechniques.part1.step08_packages_access.school.SchoolAccount;

/**
 * Non-subclass in a different package.
 */
public final class ExternalClient {
    private ExternalClient() {}

    public static void demoAccess() {
        SchoolAccount acc = new SchoolAccount();
        System.out.println("public: " + acc.publicId);

        // The following are NOT accessible here:
        // acc.protectedNote;
        // acc.packagePrivateLabel;
        // acc.privateSecret;

        StudentPortalAccount portal = new StudentPortalAccount();
        System.out.println("protected via subclass: " + portal.readProtectedNote());
        System.out.println("private via method: " + acc.revealSecretToSelf());
    }
}
