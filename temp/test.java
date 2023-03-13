public class test {
    public void run()
    {
        ClassLoader loader = this.getClassLoader();
        loader = 	Thread.currentThread().getContextClassLoader();
    }
}
