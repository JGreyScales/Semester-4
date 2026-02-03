public class PaypalProcessor extends PaymentProcessor {
    public PaypalProcessor(String email) {
        super("PayPal(" + email + ")");
    }

    @Override
    protected void doPay(double amount) {
        // pretend to call paypal
    }
}
