import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.rules.TemporaryFolder;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;

/**
 * Tests {@link ExecutionGraph} deployment when offloading job and task information into the BLOB
 * server.
 */
public class DefaultExecutionGraphDeploymentWithBlobServerTest
        extends DefaultExecutionGraphDeploymentTest {

    @ClassRule public static final TemporaryFolder TEMPORARY_FOLDER = new TemporaryFolder();

    private Set<byte[]> seenHashes =
            Collections.newSetFromMap(new ConcurrentHashMap<byte[], Boolean>());

    protected BlobServer blobServer = null;

    @Before
    public void setupBlobServer() throws IOException {
        Configuration config = new Configuration();
        // always offload the serialized job and task information
        config.setInteger(BlobServerOptions.OFFLOAD_MINSIZE, 0);
        blobServer =
                Mockito.spy(
                        new BlobServer(config, TEMPORARY_FOLDER.newFolder(), new VoidBlobStore()));
        blobWriter = blobServer;
        blobCache = blobServer;

        seenHashes.clear();
        blobServer.start();
    }
}