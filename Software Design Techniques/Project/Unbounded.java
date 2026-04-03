public class Unbounded extends Devices {

    Unbounded(String name){
        super();
        this.name = name;
    }

    boolean setCurrentState(int x){
        this.curState = x;
        return true;
    }

}
