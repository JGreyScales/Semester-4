// /**
//  * Task: Count how many integers in [start, end] are even.
//  * If start > end, swap them.
//  * start = 2 and end = 800000000 WITHOUT FOR LOOP ????
//  */

public static void main(String[] args) {
    runTest(2, 4, 2);
    runTest(2, 8, 4);
    runTest(3, 7, 2);
    runTest(3, 8, 3);
    runTest(2, 7, 3);
    runTest(4, 4, 1);
    runTest(5, 5, 0);
    runTest(10, 2, 5);
    runTest(1, 1, 0);
    runTest(1, 2, 1);
    runTest(2, 3, 1);
    runTest(2, 800_000_000, 400_000_000);
    runTest(1, 800_000_000, 400_000_000);
    runTest(3, 800_000_000, 399_999_999);
    runTest(2, 799_999_999, 399_999_999);
    runTest(1, 799_999_999, 399_999_999);
    runTest(800_000_000, 2, 400_000_000);
}

private static void runTest(int start, int end, int expected) {
    int actual = countEvensInclusive(start, end);
    System.out.println(
        "start=" + start +
        ", end=" + end +
        " | expected=" + expected +
        ", actual=" + actual +
        (actual == expected ? " True" : " False")
    );
}

// the main, and runTest is fully AI generated to save time


// total time complexity O(1)
// comparison possible swap, substraction, integer division, modulo operation
public static int countEvensInclusive(int start, int end) {
    if (start > end) {
        int temp = start;
        start = end;
        end = temp;
    }

    // get the range of our numbers, we know 50% will be even
    int range = end - start;

    // floor divide the numbers to ensure even with an odd range only whole numbers are returned
    int count = Math.floorDiv(range, 2);

    // ensure inclusivity on our bounds
    // | start | end  | extra even?         |
    // | ----- | ---- | ----------------    |
    // | odd   | odd  | none                |
    // | even  | odd  | one                 |
    // | odd   | even | one                 |
    // | even  | even | one                 |

    if (start % 2 == 0 || end % 2 ==0) {count++;}

    return count;
}