import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("== arrays vs List/ArrayList ==");

        int[] fixed = new int[3];
        fixed[0] = 7;
        fixed[1] = 8;
        fixed[2] = 9;
        System.out.println("array length=" + fixed.length);

        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("B"); // duplicates allowed
        System.out.println("ArrayList=" + arrayList);

        List<String> linkedList = new LinkedList<>(arrayList);
        linkedList.remove(1);
        System.out.println("LinkedList after remove(1)=" + linkedList);
    }
}
