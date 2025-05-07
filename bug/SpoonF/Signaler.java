public class Signaler
implements Closeable
{
private final Pipe.SinkChannel w;
private final Pipe.SourceChannel r;
private final Selector selector;
}