public class v1 {

    void main() {
        for (Filter filter : filters.getFilters()) {
            if (filter instanceof ExternalResourceHolder) {
                final Set<String> locations = ((ExternalResourceHolder) filter).getExternalResourceLocations();
                externalResources.addAll(locations);
            }
        }
    }
}

