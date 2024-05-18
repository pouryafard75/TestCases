package org.jabref.logic.bst;

public class VM implements Warn {

    public final Integer FALSE = 0;

    public final Integer TRUE = 1;

    private final Pattern ADD_PERIOD_PATTERN = Pattern.compile("([^\\.\\?\\!\\}\\s])(\\}|\\s)*$");

    private final Logger LOGGER = LoggerFactory.getLogger(VM.class);

    public static class BstEntry {

        public final BibEntry entry;

        public final Map<Strigitng, String> localStrings = new HashMap<>();

        public final Map<String, String> fields = new HashMap<>();

        public final Map<String, Integer> localIntegers = new HashMap<>();

        private final Logger LOGGER = LoggerFactory.getLogger(VM.class);

        public BstEntry(BibEntry e) {
            this.entry = e;
        }
    }
}
