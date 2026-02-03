public class Main {
    public static void main(String[] args) {
        System.out.println("== interface default methods ==");

        Logger logger = new ConsoleLogger();
        FileLogger fLogger = new FileLogger();

        logger.info("hello");
        fLogger.info("hello");
        logger.warn("careful!");
        fLogger.warn("careful!");
        logger.error("error!");
        fLogger.error("error!");
    }
}
