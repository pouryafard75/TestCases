public class test {
    public static void f1() {
        System.out.println(addSharp("f1"));
    }

    public static void main(String[] args) {
        f1();

    }

    public static String addSharp(String inp) {
        return inp + "#";
    }
}