import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void removeAllOccurrences(List<String> xs, String target) {
            Iterator<String> it = xs.iterator();
            while (it.hasNext()) {
                String current = it.next();
                if (current.equals(target)) {
                    it.remove();
                }
            }
        }
        
        public static void main(String[] args) {
            System.out.println("== arrays vs List/ArrayList ==");
    
            int[] fixed = new int[3];
            fixed[0] = 7;
            fixed[1] = 8;
            fixed[2] = 9;
            System.out.println("array length=" + fixed.length);
    
            List<String> arrayList = new ArrayList<>();
            arrayList.add("A");
            arrayList.add("A");
            arrayList.add("E");
            arrayList.add("E");
            arrayList.add("D");
            arrayList.add("D");
            arrayList.add("C");
            arrayList.add("B");
            arrayList.add("B"); // duplicates allowed
            arrayList.add("B"); // duplicates allowed
            removeAllOccurrences(arrayList, "A");
        System.out.println("ArrayList=" + arrayList);

        List<String> linkedList = new LinkedList<>(arrayList);
        linkedList.remove(1);
        removeAllOccurrences(linkedList, "E");
        System.out.println("LinkedList after remove(1)=" + linkedList);
        System.out.println("Position of D: " + linkedList.indexOf("D"));
        System.out.println("Last Position of D: " + linkedList.lastIndexOf("D"));
        List<String> sublist = linkedList.subList(0, linkedList.size());
        sublist.remove(2);
        System.out.println("LinkedList after sublist changes=" + linkedList);


    }
}
