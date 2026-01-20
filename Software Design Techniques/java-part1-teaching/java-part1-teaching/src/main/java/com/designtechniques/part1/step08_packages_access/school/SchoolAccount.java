package com.designtechniques.part1.step08_packages_access.school;

/**
 * Used to demonstrate access modifiers.
 */
public class SchoolAccount {
    public String publicId = "PUB-123";
    protected String protectedNote = "protected note";
    String packagePrivateLabel = "package-private label"; // no modifier
    private String privateSecret = "secret";

    public String revealSecretToSelf() {
        return privateSecret;
    }
}
