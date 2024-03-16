package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Coordinate;

import java.util.Arrays;
import java.util.Comparator;

public class CoordinateService {
    public static Coordinate[] sortCoordinates(Coordinate[] coordinates) {
        return Arrays.stream(coordinates)
                .sorted(Comparator.comparingDouble(Coordinate::getX)
                        .thenComparingDouble(Coordinate::getY)
                        .thenComparingDouble(Coordinate::getZ))
                .toArray(Coordinate[]::new);
    }

    public static double distanceBetweenCoordinates(Coordinate coordinate1, Coordinate coordinate2) {
        double xDifference = coordinate2.getX() - coordinate1.getX();
        double yDifference = coordinate2.getY() - coordinate1.getY();
        double zDifference = coordinate2.getZ() - coordinate1.getZ();

        return Math.sqrt(xDifference * xDifference + yDifference * yDifference + zDifference * zDifference);
    }
}