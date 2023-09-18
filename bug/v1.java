public class v1 {
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
}


