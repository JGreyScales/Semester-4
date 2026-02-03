public class Main {
    public static void main(String[] args) {
        System.out.println("== Mini-capstone: find SOLID violations ==");

        // Intentionally messy code path (students refactor it).
        OrderServiceBad svc = new OrderServiceBad();
        svc.placeOrder("customer-1", "square:3,circle:2");

        System.out.println();
        System.out.println("Now compare with the refactored version (skeleton).");

        OrderParser parser = new OrderParser();
        Shape[] shapes = parser.parse("square:3,circle:2");

        AreaCalculator calc = new AreaCalculator();
        double total = calc.totalArea(shapes);

        ReceiptPrinter printer = new ReceiptPrinter();
        printer.print(total);
    }
}
