public class InteracProcessor extends PaymentProcessor{

    public InteracProcessor(String name){
        super(name);
    }

    @Override
    protected void doPay(double amount) {
        System.out.println("interac: " + amount);
        final double tax = this.taxFor(amount);
        System.out.println("Tax total was: " + tax);
        System.out.println("total was: " + (amount + tax));
    }
}