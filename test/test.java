public class VcapApplicationListener {
	/**
     * Finds a valid path for a file from a FileStatus object.
     * @param fileStatus FileStatus object corresponding to a file,
     * or a directory.
     * @param fileSystem FileSystem in with the file should be found
     * @return The first file found
     * @throws IOException
     */

	 public static Path depthFirstSearchForFile(final FileStatus[] statusArray, final FileSystem fileSystem) throws IOException {
 		return depthFirstSearchForFile(statusArray, fileSystem, null);
	}
}