public class v {
    public void x(){
        if (!((f1 instanceof BstVMVisitor.Identifier) || (f1 instanceof ParseTree))
                && ((f2 instanceof BstVMVisitor.Identifier) || (f2 instanceof ParseTree))) {
            throw new BstVMException("Expecting two functions for while$ (line %d)".formatted(ctx.start.getLine()));
        }
    }
}