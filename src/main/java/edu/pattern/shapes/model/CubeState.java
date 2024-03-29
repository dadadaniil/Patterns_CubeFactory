package edu.pattern.shapes.model;

import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static edu.pattern.shapes.service.CoordinateService.distanceBetweenCoordinates;

public enum CubeState {
    REGULAR, INVALID;
    private static final Logger logger = Logger.getLogger(CubeState.class);

    public static CubeState detect(Coordinate[] coordinates) {
        if (coordinates == null || coordinates.length != 8) {
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
        if (uniqueDistances.size() == 3) {
            Map<Double, Integer> distanceCounts = new HashMap<>();
            for (double distance : distances) {
                distanceCounts.put(distance, distanceCounts.getOrDefault(distance, 0) + 1);
            }

            boolean validCube = distanceCounts.values().containsAll(Arrays.asList(12, 12, 4));
            if (validCube) {
                return CubeState.REGULAR;
            } else {
                return CubeState.INVALID;
            }
        } else {
            return CubeState.INVALID;
        }
    }

    public static CubeState detect(double[][] coordinates) {
        if (coordinates == null || coordinates.length != 8) {
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