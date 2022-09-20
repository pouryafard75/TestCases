public class test {

    void main() {

        eventually(new Condition() {
            @Override
            public boolean isSatisfied() throws Exception {
                System.out.println("True");
                return true;
            }

            @Override
            public boolean isReady() throws Exception {
                System.out.println("True");
                return false;
            }
        });
    }
}