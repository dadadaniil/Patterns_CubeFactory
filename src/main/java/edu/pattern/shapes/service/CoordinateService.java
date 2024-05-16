package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Coordinate;

import java.util.Arrays;
import java.util.Comparator;

public class CoordinateService {


    /**
     * Sorts an array of coordinates in ascending order based on their x, y, and z values.
     * If two coordinates have the same x value, they are sorted by their y value.
     * If they also have the same y value, they are sorted by their z value.
     *
     * @param coordinates the array of coordinates to sort
     * @return a new array containing the sorted coordinates
     */
    public static Coordinate[] sortCoordinates(Coordinate[] coordinates) {
        return Arrays.stream(coordinates)
            .sorted(Comparator.comparingDouble(Coordinate::getX)
                .thenComparingDouble(Coordinate::getY)
                .thenComparingDouble(Coordinate::getZ))
            .toArray(Coordinate[]::new);
    }

    /**
     * Calculates the Euclidean distance between two coordinates in a 3D space.
     *
     * @param coordinate1 the first coordinate
     * @param coordinate2 the second coordinate
     * @return the distance between the two coordinates
     */
    public static double distanceBetweenCoordinates(Coordinate coordinate1, Coordinate coordinate2) {
        double xDifference = coordinate2.getX() - coordinate1.getX();
        double yDifference = coordinate2.getY() - coordinate1.getY();
        double zDifference = coordinate2.getZ() - coordinate1.getZ();

        return Math.sqrt(xDifference * xDifference + yDifference * yDifference + zDifference * zDifference);
    }
}