package classDiff;

public class example {
    void a() {
        throwsList.stream().filter(exceptionInfo -> !exceptionInfo.isFound())
                .forEach(exceptionInfo -> {
                    final Token token = exceptionInfo.getName();
                    log(token.getLineNo(), token.getColumnNo(),
                            MSG_EXPECTED_TAG,
                            JavadocTagInfo.THROWS.getText(), token.getText());
                });
    }
}
