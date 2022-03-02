package RunToCursorBreakpoint;
public class RunToCursorBreakpoint extends LineBreakpoint {
  
  @Nullable
  protected static RunToCursorBreakpoint create(@NotNull Project project, @NotNull Document document, int lineIndex, boolean restoreBreakpoints) {
    VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(document);
    if (virtualFile == null) {
      return null;
    }

    PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
    SourcePosition pos = SourcePosition.createFromLine(psiFile, lineIndex);

    return new RunToCursorBreakpoint(project, pos, restoreBreakpoints);
  }

}