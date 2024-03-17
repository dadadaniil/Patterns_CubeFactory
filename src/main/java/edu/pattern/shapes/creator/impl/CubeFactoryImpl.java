package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.CubeFactory;
import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.model.CubeState;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CubeFactoryImpl implements CubeFactory {

    @Override
    public Cube createCube(Coordinate[] coordinates) {
        Cube cube = new Cube(coordinates);
        return cube;
    }

    @Override
    public List<Cube> createCubes(List<Coordinate[]> coordinates) {
        List<Cube> cubes = new ArrayList<>();
        for (Coordinate[] coordinate : coordinates) {
            cubes.add(new Cube(coordinate));
        }
        return cubes;
    }

    @Override
    public List<double[][]> createCubesFromFile(String filePath) {
        List<double[][]> validCoordinates = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(getClass().getResource(filePath).toURI()))) {
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


