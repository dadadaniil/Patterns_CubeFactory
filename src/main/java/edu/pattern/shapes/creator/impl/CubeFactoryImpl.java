package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.CubeFactory;
import edu.pattern.shapes.exception.InvalidCubeDataException;
import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.model.CubeState;
import edu.pattern.shapes.util.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CubeFactoryImpl implements CubeFactory {
    private final static Logger logger = LogManager.getLogger();
    private final FileReader fileReader = new FileReader();
    private final CoordinateFactoryImpl coordinateFactory = new CoordinateFactoryImpl();

    @Override
    public Cube createCube(Coordinate[] coordinates) {
        return new Cube(coordinates);
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
    public List<Cube> createCubesFromFile(String filePath) throws InvalidCubeDataException {
        List<Cube> cubes = new ArrayList<>();
        try {
            fileReader.readLines(filePath).forEach(line -> {
                Coordinate[] coordinates = coordinateFactory.createCoordinates(line);
                Cube cube = createAndValidateCube(coordinates);
                if (cube != null) {
                    cubes.add(cube);
                }
            });
        } catch (IOException | URISyntaxException | NumberFormatException e) {
            throw new InvalidCubeDataException("Invalid cube coordinates");
        }
        return cubes;
    }

    public Cube createAndValidateCube(Coordinate[] coordinates) {
        try {
            Cube cube = createCube(coordinates);
            if (CubeState.detect(cube.getCoordinates()) == CubeState.REGULAR) {
                return cube;
            }
        } catch (IllegalArgumentException e) {
            logger.error("Invalid cube coordinates");
        }
        return null;
    }

}


