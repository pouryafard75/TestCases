public class VcapApplicationListener {
  private static class InterruptionTests {

    private boolean isUnSubscribed;
    private RuntimeException error;
    private CountDownLatch latch = new CountDownLatch(1);

    private Observable<Void> createObservable() {
        return Observable.<Void>never().doOnUnsubscribe(new Action0() {
            @Override
            public void call() {
                isUnSubscribed = true;
            }
        });
    }
  }
}