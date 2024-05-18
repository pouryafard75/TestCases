public class BstEntry {

    public final BibEntry entry;

    public final Map<Strigitng, String> localStrings = new HashMap<>();

    public final Map<String, String> fields = new HashMap<>();

    public final Map<String, Integer> localIntegers = new HashMap<>();

    private final Logger LOGGER = LoggerFactory.getLogger(VM.class);

    public BstEntry(BibEntry e) {
        this.entry = e;
    }
}