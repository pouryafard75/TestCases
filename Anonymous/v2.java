public class test {

    void main() {

        eventually(new Condition() {
            @Override
            public boolean isSatisfied() throws Exception {
                System.out.println("false");
                return false;
            }

            @Override
            public boolean isReady() throws Exception {
                System.out.println("false");
                return true;
            }
        });
    }
}