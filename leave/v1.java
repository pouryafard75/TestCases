public final class NestedIfDepthCheck extends AbstractNestedDepthCheck {
    /**
     * A key is pointing to the warning message text in "messages.properties"
     * file.
     */
    public static final String MSG_KEY = "nested.if.depth";
    /** default allowed nesting depth. */
    private static final int DEFAULT_MAX = 1;
    /** Creates new check instance with default allowed nesting depth. */
    public NestedIfDepthCheck() {
        super(DEFAULT_MAX);
    }
    @Override
    public int[] getDefaultTokens() {
        return new int[] {TokenTypes.LITERAL_IF};
    }
    @Override
    public int[] getAcceptableTokens() {
        return new int[] {TokenTypes.LITERAL_IF};
     }

     @Override
     public void visitToken(DetailAST ast) {
         if (ast.getType() == TokenTypes.LITERAL_IF) {
             visitLiteralIf(ast);
         }
         else {
             throw new IllegalStateException(ast.toString());
         }
     }

     @Override
     public void leaveToken(DetailAST ast) {
         if (ast.getType() == TokenTypes.LITERAL_IF) {
             leaveLiteralIf(ast);
         }
         else {
             throw new IllegalStateException(ast.toString());
         }
     }

     /**
      * Increases current nesting depth.
      * @param literalIf node for if.
      */
     private void visitLiteralIf(DetailAST literalIf) {
         if (!CheckUtils.isElseIf(literalIf)) {
             nestIn(literalIf, MSG_KEY);
         }
     }

     /**
      * Decreases current nesting depth.
      * @param literalIf node for if.
      */
     private void leaveLiteralIf(DetailAST literalIf) {
         if (!CheckUtils.isElseIf(literalIf)) {
             nestOut();
         }
     }
 }