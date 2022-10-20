package classDiff;

public class example {
    void a() {
        for (ExceptionInfo exceptionInfo : throwsList) {
            if (!exceptionInfo.isFound()) {
                final Token token = exceptionInfo.getName();
                log(token.getLineNo(), token.getColumnNo(),
                        MSG_EXPECTED_TAG,
                        JavadocTagInfo.THROWS.getText(), token.getText());
            }
        }
    }
}
