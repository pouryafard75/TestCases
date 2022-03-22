public class Req {

    public void M1() throws Exception {
        final List<Geocache> caches = readGPX11(R.raw.terracaching_gpx);
        assertThat(caches).hasSize(55);

        Collections.sort(caches, new GeocodeComparator());
        final Geocache cache = caches.get(0);
        assertThat(cache.getGeocode()).isEqualTo("T");
        assertThat(cache.getName()).isEqualTo("P");
        assertThat(cache.getOwnerDisplayName()).isEqualTo("H");
        assertThat(cache.getType()).isEqualTo(CacheType.UNKNOWN);
        assertThat(cache.getSize()).isEqualTo(CacheSize.MICRO);
    }

    public void M2() throws Exception {
        final List<Geocache> caches = readGPX11(R.raw.tc99un_gpx);
        assertThat(caches).hasSize(1);

        final Geocache cache = caches.get(0);
        assertThat(cache.getShortDescription()).isEmpty();

        final List<Waypoint> waypoints = cache.getWaypoints();
        assertThat(waypoints).hasSize(4);

        final Waypoint waypoint = waypoints.get(0);
        assertThat(waypoint.getNote()).startsWith("75 feet due south of large shoreside");
    }

    public void M3() throws Exception {
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

}
