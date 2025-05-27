package bug.missingSubtrees;

public sealed class test permits A2 {
    void X() throws RuntimeException2{
        sleep(3);
    }
}
class B extends A2 {
    void m2();
}

class C implements I2 {
    void m1();
}