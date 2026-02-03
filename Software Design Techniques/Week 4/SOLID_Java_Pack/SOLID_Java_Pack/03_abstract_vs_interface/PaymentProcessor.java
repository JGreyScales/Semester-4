public abstract class PaymentProcessor {
    protected String name;

    protected PaymentProcessor(String name) {
        this.name = name;
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
