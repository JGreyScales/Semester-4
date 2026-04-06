import java.util.ArrayList;
import java.util.Random;

public class Devices {
    static ArrayList<Devices> devices = new ArrayList<>();
    int curState;
    String name;

    public Devices(){
        this.name = "";
        this.curState = 0;
    }
    

    int getCurrentState(){
        return curState;
    }

    boolean setCurrentState(int x){
        return false;
    }

    static void createDevicesForDemo(){
        // 2 switches
        new Switch("Switch 1").addDevice();
        new Switch("Switch 2").addDevice();

        new Percent("Percent 1").addDevice();
        new Percent("Percent 2").addDevice();

        new Unbounded("Unbound 1").addDevice();
        new Unbounded("Unbound 2").addDevice();

        Devices.setRandomAllDevices();
    }

    void display() {
        System.out.println("Device: " + name + " | State: " + curState);
    }

    static void displayAll(){
        for (Devices deviceObject : devices) {
            deviceObject.display();
        }
    }

    static void setRandomAllDevices() {
        Random random = new Random();
        for (Devices devicesObj : devices) {
            int number = random.nextInt(400) - 200;
            devicesObj.setCurrentState(number);
        }
    }

    boolean addDevice(){

        Devices.devices.add(this);
        return true;
    }
}
