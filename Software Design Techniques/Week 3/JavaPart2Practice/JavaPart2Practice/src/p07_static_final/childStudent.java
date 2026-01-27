package p07_static_final;

public class childStudent extends StudentCounter{

    public childStudent(String name) {
        super(name);
    }
    
    // throws error because getName is a final method and cannot be overriden
    @Override 
    public String getName(){
        return "abababa";
    }
}
