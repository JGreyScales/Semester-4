public class TaxHelper {
    private final Taxable taxable;

    public TaxHelper(Taxable taxable) {
        this.taxable = taxable;
    }

    public double applyTax(double amount) {
        return amount + taxable.taxFor(amount);
    }
}
