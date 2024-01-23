class v1{
    run() {
        throw new StoreLockException( "Unable to obtain lock on store lock file: " + storeLockFile+". Please ensure no other process is using this database, and that the directory is writable (required even for read-only access)", e );

    }
}