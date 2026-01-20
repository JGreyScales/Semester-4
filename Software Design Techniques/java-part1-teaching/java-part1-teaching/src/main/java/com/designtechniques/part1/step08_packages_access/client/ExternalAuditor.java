package com.designtechniques.part1.step08_packages_access.client;

import com.designtechniques.part1.step08_packages_access.school.SchoolAccount;

/**
 * Not a subclass, and in a different package.
 */
public class ExternalAuditor {
    public String readPublic(SchoolAccount a) {
        return a.publicId;
    }

    public String tryReadProtected(SchoolAccount a) {
        // TODO: Students: explain why this does not compile if uncommented.
        // return a.protectedNote;
        return "(see comments)";
    }
}
