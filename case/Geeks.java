import static java.lang.Integer.*;
import static java.lang.Byte.*;
import static com.github.javaparser.GeneratedJavaParserConstants.*;

class Geeks {
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