package ExVar.6.v2;

public class test {
    public static void main(String[] args) {
        String strId = id == null ? "local" : id.toString();
        if (!results.lostSegments.isEmpty()) {
            segmentsToProcess = new HashSet<>(results.lostSegments);
            results.lostSegments.clear();
            log.tracef("Found %s lost segments for %s", segmentsToProcess, strId);
        } else {
            supplier.close();
            log.tracef("Finished rehash aware operation for %s", strId);
        }
    }

}
