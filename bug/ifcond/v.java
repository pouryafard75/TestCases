public class v {
    public void x(){
        if (!((f1 instanceof Identifier) || (f1 instanceof Tree))
                && ((f2 instanceof Identifier) || (f2 instanceof Tree))) {
            throw new VMException("Expecting two functions for while$.");
        }
    }
}