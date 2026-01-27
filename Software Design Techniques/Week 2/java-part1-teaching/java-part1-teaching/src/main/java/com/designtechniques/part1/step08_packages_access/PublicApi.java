package com.designtechniques.part1.step08_packages_access;

public class PublicApi {
    public String greet(String name) {
        return InternalHelper.format("Hello", name);
    }
}
