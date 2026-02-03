import java.util.ArrayList;
import java.util.List;

public class ListWrapper<T> {
    private List<T> data;
    
    public ListWrapper(){
        this.data = new ArrayList<>(); // this grabs from line 5 for what type to use
    }

    public void safeAdd(T value){
        if (value == null){
            System.out.println("Rejecting: " + value);
            return;
        }

        System.out.println("Adding: " + value);
        this.data.add(value);
    }

    public List<T> getData(){
        return this.data;
    }
}
