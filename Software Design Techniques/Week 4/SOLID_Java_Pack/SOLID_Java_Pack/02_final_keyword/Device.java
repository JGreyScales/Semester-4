import java.util.Random;




public class Device {
    private final String serialNumber;

    public Device () {
        serialNumber = randomLetters(10);
    }

    private static String randomLetters(int length) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(length);
    
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + r.nextInt(26)));
        }
        return sb.toString();
    }

    public final String serialNumber(){
        return this.serialNumber;
    }
}
