public class test {
    public static float getDividedSum(float f)
    {
        //3
        int sum = 0;
        for (int i = 0; i < 10; i++) 
            sum += i;
        return (float)sum / f;
    }
    public static int getSum()
    {
        //1
        int sum = 0;
        for (int i = 0; i < 10; i++) 
            sum += i;
        return sum;
    }
    public static void printSum()
    {
        //2
        int sum = 0;
        for (int i = 0; i < 10; i++) 
            sum += i;
        System.out.println(sum);
    }
}
//312