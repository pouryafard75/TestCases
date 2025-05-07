public class Signaler
implements Closeable
{
private Pipe.SinkChannel w;
private Pipe.SourceChannel r;
private Selector selector;
}