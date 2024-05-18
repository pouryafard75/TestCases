package org.jabref.logic.bst;

public class VM implements Warn {

    public final Integer FALSE = 0;

    public final Integer TRUE = 1;

    private final Pattern ADD_PERIOD_PATTERN = Pattern.compile("([^\\.\\?\\!\\}\\s])(\\}|\\s)*$");

    private final Logger LOGGER = LoggerFactory.getLogger(VM.class);

}
