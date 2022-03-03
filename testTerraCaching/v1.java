public class GPXParserTest extends AbstractResourceInstrumentationTestCase {

public void testTerraCaching() throws Exception {
    final List<Geocache> caches = readGPX11(R.raw.terracaching_gpx);
    assertThat(caches).hasSize(55);

    Collections.sort(caches, new GeocodeComparator());

    final Geocache cache = caches.get(0);
    assertThat(cache.getGeocode()).isEqualTo("TC2JP");
    assertThat(cache.getName()).isEqualTo("Pingo");
    assertThat(cache.getOwnerDisplayName()).isEqualTo("harrieklomp");
    assertThat(cache.getType()).isEqualTo(CacheType.UNKNOWN);
    assertThat(cache.getSize()).isEqualTo(CacheSize.MICRO);
}
}