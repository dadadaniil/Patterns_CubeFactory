package edu.pattern.shapes.util;

import edu.pattern.shapes.model.CubeState;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    public List<double[][]> readFile(String filePath) {
        List<double[][]> validCoordinates = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] stringCoordinates = line.split(";");
                if (stringCoordinates.length == 8) {
                    double[][] coordinates = new double[8][3];
                    for (int i = 0; i < 8; i++) {
                        String[] xyz = stringCoordinates[i].split(",");
                        if (xyz.length == 3) {
                            try {
                                coordinates[i][0] = Double.parseDouble(xyz[0]);
                                coordinates[i][1] = Double.parseDouble(xyz[1]);
                                coordinates[i][2] = Double.parseDouble(xyz[2]);
                                if (CubeState.detect(coordinates) == CubeState.REGULAR) {
                                    validCoordinates.add(coordinates);
                                }
                            } catch (NumberFormatException e) {
                                // Ignore this line as it contains invalid characters
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validCoordinates;
    }
}