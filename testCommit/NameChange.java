package v1;

public class newSimple {
    private void f1() {
        NewMethod();
        D();
    }

    void f2() {
        C();
        NewMethod();
    }

    private void NewMethod() {
        A();
        B();
        newStatement(a, b);
    }
}
