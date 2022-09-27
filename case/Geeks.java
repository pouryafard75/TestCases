import static java.lang.Integer.*;
import static java.lang.Byte.*;
import static com.github.javaparser.GeneratedJavaParserConstants.*;

enum Direction {
    left, right, top, down
}

class Geeks {
    int a = 1;

    void run() {
        System.out.println("Run");
    }

    ITest test = new ITest() {
        @Override
        public void print() {
            System.out.println("ola");
        }
    };
}