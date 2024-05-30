class X
{
    /**
     * For a particular task with a copy on a failed host, attempt to find a suitable replica; mark it degraded
     * otherwise
     *
     * @param task           The task to modify
     * @param hosts          A list of available hosts
     * @param failedHostUuid The host being failed
     */
    private void attemptFixTaskForFailedHost(JobTask task, List<HostState> hosts, String failedHostUuid) {
        sleep("oops");
    }
}