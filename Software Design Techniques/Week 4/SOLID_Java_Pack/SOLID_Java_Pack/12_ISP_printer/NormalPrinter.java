public class NormalPrinter implements Printer {
    @Override public void print(String content) {
        System.out.println("NormalPrinter printing: " + content);
    }
}
