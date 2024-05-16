package edu.pattern.shapes.model;

import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static edu.pattern.shapes.service.CoordinateService.distanceBetweenCoordinates;

public enum CubeState {
    REGULAR, INVALID;
    private static final int AMOUNT_OF_CUBE_SIDES = 8;
    private static final int UNIQUE_VALUES_AMOUNT = 3;
    private static final int UNIQUE_DIAGONALS_AMOUNT = 12;
    private static final int UNIQUE_SIDES_AMOUNT = 12;
    private final static Logger logger = LogManager.getLogger();
    private static final int SQUARE_SIDES_AMOUNT = 4;

    public static CubeState detect(Coordinate[] coordinates) {
        if (coordinates == null || coordinates.length != AMOUNT_OF_CUBE_SIDES) {
            throw new IllegalArgumentException("A cube must have 8 coordinates");
        }

        List<Double> distances = new ArrayList<>();
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                double distance = distanceBetweenCoordinates(coordinates[i], coordinates[j]);
                distances.add(distance);
            }
        }

        Set<Double> uniqueDistances = new HashSet<>(distances);
        if (uniqueDistances.size() == UNIQUE_VALUES_AMOUNT) {
            Map<Double, Integer> distanceCounts = new HashMap<>();
            for (double distance : distances) {
                distanceCounts.put(distance, distanceCounts.getOrDefault(distance, 0) + 1);
            }

            boolean validCube = distanceCounts.values()
                .containsAll(Arrays.asList(UNIQUE_DIAGONALS_AMOUNT, UNIQUE_SIDES_AMOUNT, SQUARE_SIDES_AMOUNT));

            return validCube ? CubeState.REGULAR : CubeState.INVALID;
        } else {
            return CubeState.INVALID;
        }
    }

    public static CubeState detect(double[][] coordinates) {
        if (coordinates == null || coordinates.length != AMOUNT_OF_CUBE_SIDES) {
            throw new IllegalArgumentException("A cube must have 8 coordinates");
        }
        CoordinateFactoryImpl coordinateFactory = new CoordinateFactoryImpl();
        return detect(coordinateFactory.createCoordinates(coordinates));
    }


    public static CubeState detect(Cube cube) {
        CubeState state = detect(cube.getCoordinates());
        if (state == CubeState.REGULAR) {
            logger.info("Cube with id " + cube.getId() + " is regular");
            return CubeState.REGULAR;
        } else {
            logger.info("Cube with id " + cube.getId() + " is invalid");
            return CubeState.INVALID;
        }
    }
}