package com.designtechniques.part1.step08_packages_access.client;

import com.designtechniques.part1.step08_packages_access.school.SchoolAccount;

public class ExternalSubclass extends SchoolAccount {
    public void demoProtectedFromSubclass() {
        System.out.println(publicId);
        System.out.println(protectedNote);
        // System.out.println(packagePrivateLabel); // compile error
        // System.out.println(privateSecret); // compile error
    }
}
