public class MaxFreeAllocator implements Allocator {
  private final BlockMetadataManager mMetaManager;

  public MaxFreeAllocator(BlockMetadataManager metadata) {
    mMetaManager = Preconditions.checkNotNull(metadata);
  }

  @Override
  public TempBlockMeta allocateBlock(long userId, long blockId, long blockSize,
      BlockStoreLocation location) throws IOException {

    StorageDir candidateDir = null;
    }
}