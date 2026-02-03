public class CreditCardProcessor extends PaymentProcessor implements Refundable{
    public CreditCardProcessor(String merchantId) {
        super("CreditCard(" + merchantId + ")");
    }

    @Override
    protected void doPay(double amount) {
        System.out.println("Credit card " + amount);
        final double tax = this.taxFor(amount);
        System.out.println("Tax total was: " + tax);
        System.out.println("total was: " + (amount + tax));
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund $" + amount + " via " + name);
    }
}
