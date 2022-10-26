class v1 {
    public void test(final InputStream inputStream) {
        try{
            sleep(1);
        } catch (final IOException e) {
            return false;
        } catch (final SecurityException e) {
            return false;
        }
    }
}