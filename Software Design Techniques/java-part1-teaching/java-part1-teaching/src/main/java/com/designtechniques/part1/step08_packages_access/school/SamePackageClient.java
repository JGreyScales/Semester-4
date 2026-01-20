package com.designtechniques.part1.step08_packages_access.school;

public final class SamePackageClient {
    private SamePackageClient() {}

    public static void run() {
        AccessShowcase a = new AccessShowcase();
        System.out.println("  public:    " + a.pub);
        System.out.println("  protected: " + a.prot);
        System.out.println("  default:   " + a.def);
        // System.out.println(a.priv); // not accessible
        System.out.println("  private via method: " + a.readPrivateViaMethod());
    }
}
