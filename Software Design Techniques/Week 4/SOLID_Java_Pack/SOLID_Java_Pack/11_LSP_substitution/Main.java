public class Main {
    public static void main(String[] args) {
        System.out.println("== LSP (Liskov Substitution) ==");

        Bird eagle = new Eagle();
        Bird penguin = new Penguin();

        feed(eagle);
        feed(penguin);

        makeItFly(new Dove());

        shouldCalculateCorrectArea(new Rectangle(), 5, 4);

        try {
            shouldCalculateCorrectArea(new SquareBad(), 5, 4);
        } catch (AssertionError ex) {
            System.out.println("Assertion failed (expected for SquareBad): " + ex.getMessage());
        }
    }

    private static void feed(Bird b) { b.eat(); }
    private static void makeItFly(Flyable f) { f.fly(); }

    private static void shouldCalculateCorrectArea(RectangleLike r, int width, int height) {
        r.setWidth(width);
        r.setHeight(height);

        int expected = width * height;
        int got = r.area();
        if (expected != got) throw new AssertionError("Expected area=" + expected + " but got=" + got);

        System.out.println("Area OK for " + r.getClass().getSimpleName());
    }
}
