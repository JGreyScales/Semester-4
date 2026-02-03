public class SuperPrinter implements MultiFunctionDevice {
    @Override public void print(String content) { System.out.println("SuperPrinter printing: " + content); }
    @Override public void scan() { System.out.println("SuperPrinter scanning..."); }
    @Override public void fax(String number) { System.out.println("SuperPrinter faxing to " + number); }
    @Override public void email(String address) { System.out.println("SuperPrinter emailing " + address); }
}
