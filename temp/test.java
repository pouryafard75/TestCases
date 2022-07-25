public class test {
    public void a(RefactoringType refactoringType, float precision, float recall) {
        System.out.println("F-score for " + refactoringType.getDisplayName() + " refactoring is: "
                + (2 * precision * recall) / (float) (precision + recall));
    }
}
