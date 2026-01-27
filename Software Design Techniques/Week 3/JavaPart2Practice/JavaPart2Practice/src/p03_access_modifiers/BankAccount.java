package p03_access_modifiers;

/**
 * Demonstrates access modifiers.
 * Keep balance private and expose safe operations as public methods.
 */
public class BankAccount {
    private double balance; // only this class can access directly

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) initialBalance = 0;
        this.balance = initialBalance;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount target, double amount){
        if (amount > this.balance){
            return false;
        }

        this.withdraw(amount);
        target.deposit(amount);
        return true;
    }

    // package-private helper (no modifier): only visible inside this package
    void resetForDemoOnly() {
        balance = 0;
    }
}

