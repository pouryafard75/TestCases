public class VcapApplicationListener {
	public static void main(String[] args) {
		System.out.println("createDate (Default TimeZone: expected=" + parameterSet.defaultTimeZone.getDisplayName(false, TimeZone.SHORT, Locale.ROOT) + "|current="+TimeZone.getDefault().getDisplayName()+"):");
	}
}