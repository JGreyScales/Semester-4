import java.util.ArrayList;

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
    }

    void display() {
        System.out.println("Device: " + name + " | State: " + curState);
    }

    static void displayAll(){
        for (Devices deviceObject : devices) {
            deviceObject.display();
        }
    }

    boolean addDevice(){

        Devices.devices.add(this);
        return true;
    }
}
