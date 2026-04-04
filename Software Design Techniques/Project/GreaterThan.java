public class GreaterThan extends Check<Number> {
    @Override
    boolean export() {
        return super.export();
    }

    @Override
    boolean peform() {
        // double to allow > operator
        return input1.doubleValue() > input2.doubleValue();
    }
}
