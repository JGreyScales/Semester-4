package p12_arrays_lists_arraylist;

import java.util.ArrayList;
import java.util.List;
import support.config.Config;

public class Main {
    public static void main(String[] args) {
        int n = Config.getInt("demo.list.size", 5);

        int[] fixed = new int[n]; // fixed length
        for (int i = 0; i < fixed.length; i++) fixed[i] = (i + 1) * 10;

        System.out.println("Array length=" + fixed.length);
        System.out.println("Array[0]=" + fixed[0]);

        List<Integer> list = new ArrayList<>(); // resizable
        for (int i = 0; i < n; i++) list.add((i + 1) * 10);

        System.out.println("List size=" + list.size());
        System.out.println("List get(0)=" + list.get(0));

        // TODO: EXERCISE 1
        // Implement a method that finds the max value in an int[] (no Collections).
        // Then implement the same for a List<Integer>.

        // TODO: EXERCISE 2
        // Remove all values >= 30 from the list safely (avoid ConcurrentModificationException).
    }
}

