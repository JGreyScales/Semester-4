public class Main {
    public static void main(String[] args) {
        System.out.println("== final keyword demo ==");

        final int maxRetries = 3;
        System.out.println("maxRetries=" + maxRetries);

        final StringBuilder sb = new StringBuilder("Hello");
        sb.append(" world"); // allowed: object state can change
        System.out.println(sb);

        // sb = new StringBuilder("Nope"); // NOT allowed: reference cannot be re-assigned

        Vehicle v = new Vehicle();
        v.start();

        Device d = new Device();
        System.out.println(d.serialNumber());
    }
}