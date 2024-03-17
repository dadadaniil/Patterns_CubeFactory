package edu.pattern.shapes.creator;

import edu.pattern.shapes.model.Coordinate;

import java.util.List;

public interface CoordinateFactory {
    Coordinate[] createCoordinates(double[][] coordinates);
    Coordinate createCoordinate(double x, double y, double z);
}
