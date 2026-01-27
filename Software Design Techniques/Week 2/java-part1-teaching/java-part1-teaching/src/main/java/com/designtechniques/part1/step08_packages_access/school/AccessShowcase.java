package com.designtechniques.part1.step08_packages_access.school;

public class AccessShowcase {
    public String pub = "public";
    protected String prot = "protected";
    String def = "default";
    private String priv = "private";

    public String readPrivateViaMethod() {
        return priv;
    }
}
