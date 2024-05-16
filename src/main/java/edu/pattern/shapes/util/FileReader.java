package edu.pattern.shapes.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public Stream<String> readLines(String filePath) throws URISyntaxException, IOException {
        return Files.lines(Paths.get(getClass().getResource(filePath).toURI()));
    }
}
