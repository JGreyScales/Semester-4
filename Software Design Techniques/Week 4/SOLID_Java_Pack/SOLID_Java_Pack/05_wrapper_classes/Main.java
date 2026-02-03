public class Main {


    public static void main(String[] args) {
        System.out.println("== wrapper classes ==");

        ListWrapper<Integer> nums = new ListWrapper<>();
        nums.safeAdd(10); // autoboxing
        nums.safeAdd(20);
        nums.safeAdd(null);

        int sum = 0;
        for (Integer n : nums.getData()) { // unboxing
            sum += n;
        }
        System.out.println("sum=" + sum);

    }
}
