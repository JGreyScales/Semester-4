public class Check<A extends Number> extends AutomatedEvent {
    A input1;
    A input2;

    @Override
    String export(String... dataToAdd) {
       String actualData = (dataToAdd.length > 0) ? dataToAdd[0] : "";
       StringBuilder sb = new StringBuilder(actualData);
       sb.append("\nInput1: " + input1 + "\nInput2: " + input2);
       return sb.toString();
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
