package com.designtechniques.part1.step08_packages_access.school;

public class SchoolMember {
    public void demoSamePackageAccess() {
        SchoolAccount acc = new SchoolAccount();
        System.out.println(acc.publicId);
        System.out.println(acc.protectedNote);
        System.out.println(acc.packagePrivateLabel);
        // System.out.println(acc.privateSecret); // compile error
    }
}
