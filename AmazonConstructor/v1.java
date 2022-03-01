package AmazonConstructor;
public class AmazonElasticFileSystemAsyncClient extends
        AmazonElasticFileSystemClient implements AmazonElasticFileSystemAsync {

    public AmazonElasticFileSystemAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
            ExecutorService executorService) {
        this(awsCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public AmazonElasticFileSystemAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration,
                Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }
}
