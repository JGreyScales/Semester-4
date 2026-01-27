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


        int fixedMax = Integer.MIN_VALUE;
        for (int i = 0; i < fixed.length; i++) {
            if (fixed[i] > fixedMax){
                fixedMax = fixed[i];
            }
        }

        int listMax = Integer.MIN_VALUE;
        for (Integer i : list) {
            if (i > listMax){
                listMax = i;
            }
        }

        System.out.println("Max in fixed = " + fixedMax);
        System.out.println("Max in list = " + listMax);

        System.out.println("Before filtering:" + list.toString());

        int target = list.size();
        for (int i = 0; i < target; i++) {
            if (list.get(i) >= 30){
                list.remove(i--);
                target--;
            }
        }

        System.out.println("After filtering:" + list.toString());

    }
}

