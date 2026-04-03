import java.util.ArrayList;

public class Devices {
    static ArrayList<Devices> devices;
    int curState;

    public Devices(){
        this.curState = 0;
    }
    
    int getCurrentState(){
        return curState;
    }

    boolean setCurrentState(int x){
        return false;
    }

    boolean addDevice(){
        Devices.devices.add(this);
        return true;
    }
}
