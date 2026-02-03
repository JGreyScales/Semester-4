public class Main {
    public static void main(String[] args) {
        System.out.println("== interface default methods ==");

        Logger logger = new ConsoleLogger();
        logger.info("hello");
        logger.warn("careful!");
    }
}
