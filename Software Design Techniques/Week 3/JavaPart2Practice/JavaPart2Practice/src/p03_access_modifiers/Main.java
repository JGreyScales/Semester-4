package p03_access_modifiers;

public class Main {
    public static void main(String[] args) {
        BankAccount a = new BankAccount(100);
        BankAccount b = new BankAccount(50);

        a.deposit(25);
        boolean ok = a.withdraw(70);

        System.out.println("Withdraw success? " + ok);
        System.out.println("A balance: " + a.getBalance());
        System.out.println("B balance: " + b.getBalance());

        // TODO: EXERCISE 2
        // Call transferTo once you implement it, then print both balances.
    }
}

