public class Main {
    public static void main(String[] args) {
        System.out.println("== ISP (Interface Segregation) ==");

        Printer normal = new NormalPrinter();
        normal.print("Hello");

        MultiFunctionDevice mfd = new SuperPrinter();
        mfd.print("Report");
        mfd.scan();
        mfd.email("boss@example.com");
    }
}
