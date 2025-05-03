package bug.missingSubtrees;

public sealed class test permits A {
    void X() throws RuntimeException{
        sleep(3);
    }
}
class B extends A {
    void m2();
}

class C implements I {
    void m1();
}

