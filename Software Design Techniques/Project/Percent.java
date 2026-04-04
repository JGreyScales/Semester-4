public class Percent extends Devices {
    public Percent(String name){
        super();
        this.name = name;
    }

    boolean setCurrentState(int x){
        
        if (x > 100 || x < 0){
            return false;
        }

        this.curState = x;
        return true;
    }
}
