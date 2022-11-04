package wiredclub.net.katas.application.loccount;

public class FileDetails {

	private final String fileName;
	private final long numberOfLines;
	private final long numberOfCodeLines;

	public FileDetails(String fileName, long numberOfLines, long numberOfCodeLines) {
		this.fileName = fileName;
		this.numberOfLines = numberOfLines;
		this.numberOfCodeLines = numberOfCodeLines;
	}

	public String getFileName() {
		return fileName;
	}

	public long getNumberOfLines() {
		return numberOfLines;
	}

	public long getNumberOfCodeLines() {
		return numberOfCodeLines;
	}
}
