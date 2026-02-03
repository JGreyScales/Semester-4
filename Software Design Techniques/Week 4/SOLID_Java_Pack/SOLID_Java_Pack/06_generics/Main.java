public class Main {
    public static void main(String[] args) {
        System.out.println("== generics ==");

        Box<String> b1 = new Box<>("hello");
        Box<Integer> b2 = new Box<>(42);

        System.out.println(b1.get());
        System.out.println(b2.get());
    }
}
