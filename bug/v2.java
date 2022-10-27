public class v2 {

    void main() {   
        filters.getFilters().stream().filter(filter -> filter instanceof ExternalResourceHolder)
        .forEach(filter -> {
            final Set<String> locations =
                ((ExternalResourceHolder) filter).getExternalResourceLocations();
            externalResources.addAll(locations);
        });
    }
}