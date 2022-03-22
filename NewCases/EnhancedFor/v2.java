import java.lang.Thread;
import java.util.Arrays;

public class printArr {
    public void M1() {
        int[] numbers = { 3, 9, 5, -5 };
        printArr(numbers);
    }

    public void M2(int input) throws InterruptedException {
        Thread.sleep(input);
    }

    public void printArr(int[] input) {
        System.out.println(Arrays.toString(input));
    }
}
