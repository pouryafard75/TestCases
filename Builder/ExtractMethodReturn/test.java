public class test{
    private int a = 10;
    private static class InterruptionTests {

        private boolean isUnSubscribed;
        private final AtomicReference<RuntimeException> errorRef = new AtomicReference<RuntimeException>();
        private CountDownLatch latch = new CountDownLatch(1);

        private Action0 createOnUnsubscribe() {
            return new Action0() {
                @Override
                public void call() {
                    isUnSubscribed = true;
                }
            };
        }

        private Observable<Void> createNeverObservable() {
            return Observable.<Void>never().doOnUnsubscribe(createOnUnsubscribe());
        }
    }
}