// After refactoring:
package ExVar.1.v2;
public class Run {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int xSquared = x * x;
        int threeX = 3 * x;
        int ySquared = y * y;
        int fiveY = 5 * y;
        int result = xSquared + threeX + ySquared + fiveY;
        System.out.println(result);
    }
    public static void test(String[] args) {
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