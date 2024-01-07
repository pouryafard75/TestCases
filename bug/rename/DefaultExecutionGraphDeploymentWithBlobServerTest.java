

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Tests {@link ExecutionGraph} deployment when offloading job and task information into the BLOB
 * server.
 */
class DefaultExecutionGraphDeploymentWithBlobServerTest
        extends DefaultExecutionGraphDeploymentTest {

    @TempDir Path temporaryFolder;

    private Set<byte[]> seenHashes =
            Collections.newSetFromMap(new ConcurrentHashMap<byte[], Boolean>());

    protected BlobServer blobServer = null;

    @BeforeEach
    public void setupBlobServer() throws IOException {
        Configuration config = new Configuration();
        // always offload the serialized job and task information
        config.setInteger(BlobServerOptions.OFFLOAD_MINSIZE, 0);
        blobServer =
                new AssertBlobServer(
                        config, TempDirUtils.newFolder(temporaryFolder), new VoidBlobStore());
        blobWriter = blobServer;
        blobCache = blobServer;

        seenHashes.clear();
        blobServer.start();
    }
}