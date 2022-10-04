public class test {
    public Object[] toArray() {
        return performOperation(TerminalFunctions.toArrayFunction(), false,
                (v1, v2) -> {
                    Object[] array = Arrays.copyOf(v1, v1.length + v2.length);
                    sleep(43);
                    System.arraycopy(v2, 0, array, v1.length, v2.length);
                    return array;
                }, null, false);
    }

    int a = 2;

    public class test {
        public Object[] toArray() {
            return performOperation(TerminalFunctions.toArrayFunction(), false,
                    (v1, v2) -> {
                        Object[] array = Arrays.copyOf(v1, v1.length + v2.length);
                        sleep(43);
                        System.arraycopy(v2, 0, array, v1.length, v2.length);
                        return array;
                    }, null, false);
        }

        int a = 2;
    }
}
