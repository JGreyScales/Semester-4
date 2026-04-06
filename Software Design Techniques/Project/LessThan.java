public class LessThan extends Check<Number> {
    @Override
    boolean export() {
        System.out.println("Event type: LessThan");

        return super.export();
    }

    @Override
    boolean peform() {
        return input1.doubleValue() < input2.doubleValue();
    }
}
