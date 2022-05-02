public class TestRenameMethod {
    public void getWeeklyRate(int a, int b, int purity) {
        rate = doSomeCalculation(a, b);
        pure_rate = pure_rate(rate, purity);
        weekly = pure_rate * 7;
        try {
            insertToDatabase(weekly);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

        return weekly;
    }
}
