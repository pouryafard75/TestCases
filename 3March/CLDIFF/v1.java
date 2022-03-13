public class ThreadPoolTaskScheduler extends ExecutorConfigurationSupport {

    public ListenableFuture<?> submitListenable(Runnable task) {
        ExecutorService executor = getScheduledExecutor();
        try {

            ListenableFutureTask<Object> future = new ListenableFutureTask<>(task, null);
            executor.execute(errorHandlingTask(future, false));
            return future;

        } catch (RejectedExecutionException ex) {
        }
    }

    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        ExecutorService executor = getScheduledExecutor();
        try {

            ListenableFutureTask<T> future = new ListenableFutureTask<>(task);
            executor.execute(errorHandlingTask(future, false));
            return future;

        } catch (RejectedExecutionException ex) {

        }
    }

}
