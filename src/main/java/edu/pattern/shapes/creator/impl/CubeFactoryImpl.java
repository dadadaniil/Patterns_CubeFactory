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
public List<Cube> createCubesFromFile(String filePath) {
    List<Cube> cubes = new ArrayList<>();
    try (Stream<String> lines = Files.lines(Paths.get(getClass().getResource(filePath).toURI()))) {
        lines.forEach(line -> {
            String[] stringCoordinates = line.split(";");
            if (stringCoordinates.length == 8) {
                Coordinate[] coordinates = new Coordinate[8];
                for (int i = 0; i < 8; i++) {
                    String[] xyz = stringCoordinates[i].split(",");
                    if (xyz.length == 3) {
                        try {
                            double x = Double.parseDouble(xyz[0]);
                            double y = Double.parseDouble(xyz[1]);
                            double z = Double.parseDouble(xyz[2]);
                            coordinates[i] = new Coordinate(x, y, z);
                        } catch (NumberFormatException e) {
                            // Handle the exception
                        }
                    }
                }
                Cube cube = createCube(coordinates);
                if (CubeState.detect(cube.getCoordinates()) == CubeState.REGULAR) {
                    cubes.add(cube);
                }
            }
        });
    } catch (Exception e) {
//        e.printStackTrace();
    }
    return cubes;
}

}


