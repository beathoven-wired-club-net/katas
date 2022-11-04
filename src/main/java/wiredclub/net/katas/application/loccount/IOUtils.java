package wiredclub.net.katas.application.loccount;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class IOUtils {

	/**
	 * Traverses from parent directory into all subdirectories and collects all files of given extension.
	 * Found files are added to ArrayList codeFiles.
	 *
	 * @param files array of files to check if they are ending with extension
	 * @param extension extension of files
	 * @return a list of files with given extension
	 */
	public List<String> findAllFilesWithExtension(File[] files, String extension) {
		List<String> codeFiles = new ArrayList<>();
		if (files != null) {
			for (File filename : files) {
				if (filename.isDirectory()) {
					codeFiles.addAll(findAllFilesWithExtension(filename.listFiles(), extension));
				} else {
					if (filename.getName().endsWith(extension)) {
						codeFiles.add(filename.getAbsolutePath());
					}
				}
			}
		}
		return codeFiles;
	}

	public Stream<String> getLinesOfFile(String file) throws IOException {
		return Files.lines(Paths.get(file), StandardCharsets.UTF_8);
	}
}
