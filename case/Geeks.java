class Geeks {
    public void test(final InputStream inputStream) {
        try{
            sleep(1);
        } catch (final IOException | SecurityException e) {
            return false;
        }
    }
}