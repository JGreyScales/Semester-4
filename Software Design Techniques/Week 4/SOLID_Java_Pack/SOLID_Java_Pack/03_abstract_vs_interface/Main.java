public class Main {
    public static void main(String[] args) {
        System.out.println("== abstract class vs interface ==");

        PaymentProcessor p1 = new CreditCardProcessor("ACME-CC");
        PaymentProcessor p2 = new PaypalProcessor("pedro@example.com");

        p1.pay(25.0);
        p2.pay(25.0);
    }
}
