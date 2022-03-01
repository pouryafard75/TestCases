package AmazonConstructor;
public class AmazonElasticFileSystemAsyncClient extends
        AmazonElasticFileSystemClient implements AmazonElasticFileSystemAsync {

    public AmazonElasticFileSystemAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            com.amazonaws.ClientConfiguration clientConfiguration) {

        this(awsCredentialsProvider, clientConfiguration,
                java.util.concurrent.Executors
                        .newFixedThreadPool(clientConfiguration
                                .getMaxConnections()));
    }

    public AmazonElasticFileSystemAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            java.util.concurrent.ExecutorService executorService) {

        this(awsCredentialsProvider, new com.amazonaws.ClientConfiguration(),
                executorService);
    }

}