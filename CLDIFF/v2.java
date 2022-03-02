public class ThreadPoolTaskScheduler extends ExecutorConfigurationSupport {

    public ListenableFuture<?> submitListenable(Runnable task) {
        ExecutorService executor = getScheduledExecutor();
        try {

            ListenableFutureTask<Object> listenableFuture = new ListenableFutureTask<>(task, null);
            executeAndTrack(executor, listenableFuture);
            return listenableFuture;

        } catch (RejectedExecutionException ex) {
        }
    }

    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        ExecutorService executor = getScheduledExecutor();
        try {

            ListenableFutureTask<T> listenableFuture = new ListenableFutureTask<>(task);
            executeAndTrack(executor, listenableFuture);
            return listenableFuture;

        } catch (RejectedExecutionException ex) {
        }
    }

    private void executeAndTrack(ExecutorService executor, ListenableFutureTask<?> listenableFuture) {
    }

    @Override
    protected void cancelRemainingTask(Runnable task) {
    }

}
