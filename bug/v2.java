public class v2 {
    static enum Allocation {
			AVAILABLE("V"), ALLOCATED("A");
			String code;
			private Allocation(String code) {
				this.code = code;
			}
			public static Allocation of(String code) {
				for (Allocation value : values()) {
					if (value.code.equals(code)) {
						return value;
					}
				}
				throw new IllegalArgumentException();
			}
		}

    void main() {   
        test();
        filters.getFilters().stream().filter(filter -> filter instanceof ExternalResourceHolder)
        .forEach(filter -> {
            final Set<String> locations =
                ((ExternalResourceHolder) filter).getExternalResourceLocations();
            externalResources.addAll(locations);
        });
    }
}