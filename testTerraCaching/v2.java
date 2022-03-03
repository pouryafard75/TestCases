public class GPXParserTest extends AbstractResourceInstrumentationTestCase {

public void testTerraCachingOldCollection() throws Exception {
    final List<Geocache> caches = readGPX11(R.raw.terracaching_gpx);
    assertThat(caches).hasSize(55);

    Collections.sort(caches, new GeocodeComparator());

    final Geocache cache = caches.get(0);
    assertThat(cache.getGeocode()).isEqualTo("TC2JP");
    assertThat(cache.getName()).isEqualTo("Pingo");
    assertThat(cache.getOwnerDisplayName()).isEqualTo("harrieklomp");
    assertThat(cache.getType()).isEqualTo(CacheType.MULTI);
    assertThat(cache.getSize()).isEqualTo(CacheSize.MICRO);
}

public void testTerraCaching() throws Exception {
    final List<Geocache> caches = readGPX11(R.raw.tcehl_gpx);
    assertThat(caches).hasSize(1);

    final Geocache cache = caches.get(0);
    assertThat(cache.getGeocode()).isEqualTo("TCEHL");
    assertThat(cache.getName()).isEqualTo("Joseph Schoeninger");
    assertThat(cache.getOwnerDisplayName()).isEqualTo("Berengarius");
    assertThat(cache.getType()).isEqualTo(CacheType.VIRTUAL);
    assertThat(cache.getLocation()).isEqualTo("Baden-Wurttemberg, Germany");
    assertThat(cache.getUrl()).isEqualTo("http://www.terracaching.com/Cache/TCEHL");
    assertThat(cache.getDescription()).startsWith("<b> Hier ruht </b>");
    assertThat(cache.getHint()).isEmpty();

    // make sure we don't parse the standard "GC_WayPoint1"
    assertThat(cache.getShortDescription()).isEmpty();
}

public void testTerraCachingLogs() throws Exception {
    final List<Geocache> caches = readGPX11(R.raw.tcavl_gpx);
    assertThat(caches).hasSize(1);

    final List<LogEntry> logs = caches.get(0).getLogs();
    assertThat(logs).hasSize(6);

    final LogEntry log = logs.get(0);
    assertThat(log.author).isEqualTo("toubiV");
    assertThat(log.type).isEqualTo(LogType.FOUND_IT);
    assertThat(log.log).startsWith("Visited the nearby Geocache");
    assertThat(log.log).endsWith("Nice location.");
    assertThat(log.date).isNotEqualTo(0);
}

public void testTerraCachingMulti() throws Exception {
    final List<Geocache> caches = readGPX11(R.raw.tc99un_gpx);
    assertThat(caches).hasSize(1);

    final Geocache cache = caches.get(0);
    assertThat(cache.getShortDescription()).isEmpty();

    final List<Waypoint> waypoints = cache.getWaypoints();
    assertThat(waypoints).hasSize(4);

    final Waypoint waypoint = waypoints.get(0);
    assertThat(waypoint.getNote()).startsWith("75 feet due south of large shoreside");
}

}