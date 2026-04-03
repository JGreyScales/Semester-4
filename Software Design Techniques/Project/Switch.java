public class Switch extends Devices {

    public Switch(){
        super();
    }

    @Override
    boolean setCurrentState(int _x){
        // we discard the parameter for this
        if (this.curState == 0){
            this.curState = 1;
        } else {
            this.curState = 0;
        }
        return true;
    }
}
