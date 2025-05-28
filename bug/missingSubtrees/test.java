package bug.missingSubtrees;

import java.util.TreeSet;

public sealed class test permits A2 {
    void X(){
        TreeSet<Keyword> treeSet = new TreeSet<Keyword>(tm.values());
    }
}