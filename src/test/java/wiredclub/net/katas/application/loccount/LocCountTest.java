package wiredclub.net.katas.application.loccount;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocCountTest {

	private final static Logger LOG = LoggerFactory.getLogger(LocCountTest.class);
	public static final String FILE_TO_TEST = "Example.java";

	private final CountUtils countUtils = new CountUtils();

	@Test
	public void countLines() throws IOException, URISyntaxException {
		Stream<String> stream = Files.lines(getResourcePath(FILE_TO_TEST), StandardCharsets.UTF_8);

		long numberOfLines = countUtils.countLines(stream);
		// LOG.debug("#lines: {}", numberOfLines);
		assertEquals(12, numberOfLines, "Example.java should have 10 lines total.");
	}

	@Test
	public void countLinesOfCode() throws IOException, URISyntaxException {
		Stream<String> stream = Files.lines(getResourcePath(FILE_TO_TEST), StandardCharsets.UTF_8);

		long numberOfLines = countUtils.countLinesOfCode(stream);
		// LOG.debug("#lines: {}", numberOfLines);
		assertEquals(8, numberOfLines, "Example.java should have 5 lines of code.");
	}

	private Path getResourcePath(String resource) throws URISyntaxException {
		URI uri = Objects.requireNonNull(getClass().getClassLoader().getResource(resource)).toURI();
		return Paths.get(Paths.get(uri).toFile().getAbsolutePath());
	}
}
