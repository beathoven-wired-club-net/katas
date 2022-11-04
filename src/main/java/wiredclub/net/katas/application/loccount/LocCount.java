package wiredclub.net.katas.application.loccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * LocCount is a simple application which counts the number of code lines in a
 * directory and its subdirectories.<br/>
 * <br/>
 * The algorithm traverses through the directory hierarchy of the given
 * directory, collects files with the given extension and returns those in a
 * list. For every file in this list the number of code lines and the number of
 * lines of the file are determined.
 */
public class LocCount {

	private final static Logger LOG = LoggerFactory.getLogger(LocCount.class);

	private final static String EXTENSION_JAVA = ".java";

	private final IOUtils ioUtils;
	private final CountUtils countUtils;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: LocCount <path>");
			return;
		}

		new LocCount().run(args[0]);
	}

	private LocCount() {
		ioUtils = new IOUtils();
		countUtils = new CountUtils();
	}

	private void run(String dir) {
		// LOG.debug("dir: {}", dir);
		List<String> fileNames = ioUtils.findAllFilesWithExtension(new File(dir).listFiles(), EXTENSION_JAVA);
		// LOG.debug("fileNames: {}", fileNames);

		List<FileDetails> fileDetailsList = collectData(fileNames);

		out(fileDetailsList);
	}

	private List<FileDetails> collectData(List<String> fileNames) {
		List<FileDetails> fileDetailsList = new ArrayList<>();
		for (String fileName : fileNames) {
			try {
				long lineCount = countUtils.countLines(ioUtils.getLinesOfFile(fileName));
				long locCount = countUtils.countLinesOfCode(ioUtils.getLinesOfFile(fileName));

				fileDetailsList.add(new FileDetails(fileName, lineCount, locCount));
			} catch (IOException e) {
				LOG.warn("{}: Could not determine number of lines. {}", fileName, e.getMessage());
			}
		}
		return fileDetailsList;
	}

	private void out(List<FileDetails> fileDetailsList) {
		long totalLines = 0;
		long totalLoc = 0;

		for (FileDetails fileDetails : fileDetailsList) {
			long numberOfLines = fileDetails.getNumberOfLines();
			long numberOfCodeLines = fileDetails.getNumberOfCodeLines();

			System.out.println(fileDetails.getFileName() + " " + numberOfLines + " " + numberOfCodeLines);

			totalLines += numberOfLines;
			totalLoc += numberOfCodeLines;
		}

		System.out.println("Total:");
		System.out.println("  Lines: " + totalLines);
		System.out.println("  LOC: " + totalLoc);
	}
}
