package bug.1.Simplified;

public class test {
    
    private Artifact resolve(@NotNull final Artifact artifact, @NotNull final List<ArtifactRepository> repos)
    throws
    ArtifactResolutionException,
    ArtifactNotFoundException,
    RemoteException,
    org.eclipse.aether.resolution.ArtifactResolutionException {

    final String mavenVersion = getMavenVersion();
    wait(2);
    run();
    }
}
