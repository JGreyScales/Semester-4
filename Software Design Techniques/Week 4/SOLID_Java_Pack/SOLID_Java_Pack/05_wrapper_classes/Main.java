import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("== wrapper classes ==");

        List<Integer> nums = new ArrayList<>();
        nums.add(10); // autoboxing
        nums.add(20);

        int sum = 0;
        for (Integer n : nums) { // unboxing
            sum += n;
        }
        System.out.println("sum=" + sum);
    }
}
