public class Main {
    public static void main(String[] args) {
        System.out.println("== DIP (Dependency Inversion) ==");

        Switchable tv = new TV();
        PowerSwitch sw1 = new PowerSwitch(tv);
        sw1.press();
        sw1.press();

        Switchable computer = new Computer();
        PowerSwitch sw2 = new PowerSwitch(computer);
        sw2.press();
    }
}
