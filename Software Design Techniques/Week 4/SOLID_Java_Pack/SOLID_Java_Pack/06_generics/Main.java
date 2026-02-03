public class Main {
    public static void main(String[] args) {
        System.out.println("== generics ==");

        Box<String> b1 = new Box<>("hello", String.class);
        Box<Integer> b2 = new Box<>(42, Integer.class);
        Box<Integer> b3 = new Box<>(50, Integer.class);

        System.out.println(b1.get());
        System.out.println(b2.get());
        System.out.println(b1.hasSameTypeAs(b2));
        System.out.println(b1.hasSameTypeAs(b1));

        Box.copy(b2, b3);
        System.out.println(b3.get());
    }
}
