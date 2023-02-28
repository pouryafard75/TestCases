package ExVar.6.v1;

public class test {
    public static void main(String[] args) {
        if (!results.lostSegments.isEmpty()) {
            segmentsToProcess = new HashSet<>(results.lostSegments);
            results.lostSegments.clear();
            log.tracef("Found %s lost segments for identifier %s", segmentsToProcess, id);
        } else {
            supplier.close();
            log.tracef("Finished rehash aware operation for id %s", id);
        }
    }

}
