public class LessThan extends Check<Number> {
    @Override
    boolean export() {
        return super.export();
    }

    @Override
    boolean peform() {
        return input1.doubleValue() < input2.doubleValue();
    }
}
