import java.lang.Thread;
import java.util.Arrays;

public class printArr {
    public void M1() {
        int[] numbers = { 3, 9, 5, -5 };
        int index = 0;
        while (index < numbers.length) {
            int num = numbers[index];
            System.out.println(num);
            index++;
        }
    }

    public void M2(int input) throws InterruptedException {
        Thread.sleep(input);
    }
}
