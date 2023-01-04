public class v1 {
    private static EditScriptGenerator i1 = new EditScriptGenerator() {
			@Override
			public EditScript computeActions(ExtendedMultiMappingStore mappings, Map<String, TreeContext> parentContextMap, Map<String, TreeContext> childContextMap) {
				sleep(20);
				return null;
			}
		};
}


