package RunToCursorBreakpoint;
public class RunToCursorBreakpoint extends LineBreakpoint {

  @Nullable
  protected static RunToCursorBreakpoint create(@NotNull Project project, @NotNull XSourcePosition position, boolean restoreBreakpoints) {
    PsiFile psiFile = PsiManager.getInstance(project).findFile(position.getFile());
    return new RunToCursorBreakpoint(project, SourcePosition.createFromOffset(psiFile, position.getOffset()), restoreBreakpoints);
  }
  
  @Override
  protected boolean acceptLocation(final DebugProcessImpl debugProcess, ReferenceType classType, final Location loc) {
    if (!super.acceptLocation(debugProcess, classType, loc)) return false;
    return ApplicationManager.getApplication().runReadAction(new Computable<Boolean>() {
      @Override
      public Boolean compute() {
        PsiElement expectedElement = myCustomPosition.getElementAt();
        if (expectedElement != null) {
          SourcePosition position = debugProcess.getPositionManager().getSourcePosition(loc);
          if (position != null) {
            PsiElement currentElement = position.getElementAt();
            if (currentElement != null) {
              NavigatablePsiElement expectedMethod = PsiTreeUtil.getParentOfType(expectedElement, PsiMethod.class, PsiLambdaExpression.class);
              NavigatablePsiElement currentMethod = PsiTreeUtil.getParentOfType(currentElement, PsiMethod.class, PsiLambdaExpression.class);
              return Comparing.equal(expectedMethod, currentMethod);
            }
          }
        }
        return true;
      }
    });
  }

} 