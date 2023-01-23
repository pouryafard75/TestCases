package ExVar.2.v1;

public class Run {
    @Override
	public void onApplicationEvent(SpringApplicationEvent event) {
		if (this.triggerEventType.isInstance(event)) {
			if (created.compareAndSet(false, true)) {
				try {
					writePidFile(event);
				}
				catch (Exception ex) {
					logger.warn(String.format("Cannot create pid file %s", this.file), ex);
				}
			}
		}
	}
}
