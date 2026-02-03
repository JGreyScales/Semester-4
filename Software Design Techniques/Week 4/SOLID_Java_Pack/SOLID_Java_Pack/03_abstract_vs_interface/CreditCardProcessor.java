public class CreditCardProcessor extends PaymentProcessor implements Refundable {
    public CreditCardProcessor(String merchantId) {
        super("CreditCard(" + merchantId + ")");
    }

    @Override
    protected void doPay(double amount) {
        // pretend to call gateway
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund $" + amount + " via " + name);
    }
}
