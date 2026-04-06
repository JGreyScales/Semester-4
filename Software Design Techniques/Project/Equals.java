public class Equals extends Check<Number> {
    @Override
    boolean export() {
        System.out.println("Event type: Equals");

        return super.export();
    }

    @Override
    boolean peform() {
        return input1 == input2;
    }
}
