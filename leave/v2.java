package com.puppycrawl.tools.checkstyle.checks.coding;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.checks.CheckUtils;
/**
 * Restricts nested if-else blocks to a specified depth (default = 1).
 *
 * @author <a href="mailto:simon@redhillconsulting.com.au">Simon Harris</a>
 */
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
     public void visitToken(DetailAST literalIf) {
         if (!CheckUtils.isElseIf(literalIf)) {
             nestIn(literalIf, MSG_KEY);
         }
     }

     @Override
     public void leaveToken(DetailAST literalIf) {
         if (!CheckUtils.isElseIf(literalIf)) {
             nestOut();
         }
     }

 }