public abstract class PaymentProcessor implements Taxable{
    protected String name;

    protected PaymentProcessor(String name) {
        this.name = name;
    }


    @Override
    public double taxFor(double amount) {
        return amount * 0.13;
    }

    public void pay(double amount) {
        validate(amount);
        doPay(amount);
        System.out.println("Paid $" + amount + " using " + name);
    }

    protected void validate(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be > 0");
    }
   
    protected abstract void doPay(double amount);
}
