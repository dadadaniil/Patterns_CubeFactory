package edu.pattern.shapes.creator;

import edu.pattern.shapes.model.Coordinate;


public interface CoordinateFactory {
    Coordinate[] createCoordinates(double[][] coordinates);

    Coordinate createCoordinate(double x, double y, double z);

    Coordinate[] createCoordinates(String line);
}
