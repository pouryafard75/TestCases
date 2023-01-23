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
					String message = String
							.format("Cannot create pid file %s", this.file);
					if (failOnWriteError(event)) {
						throw new IllegalStateException(message, ex);
					}
					logger.warn(message, ex);
				}
			}
		}
	}
}
