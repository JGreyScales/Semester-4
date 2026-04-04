public class Check<A extends Number> extends AutomatedEvent {
    A input1;
    A input2;

    @Override
    boolean export() {
       System.out.println("Input1: " + input1 + "\nInput2: " + input2);
       return true;
    }

    void setInput1(A x){
        input1 = x;
    }

    void setInput2(A x){
        input2 = x;
    }

    void setAllPassState(boolean x){
        allNeedToPass = x;
    }
}
