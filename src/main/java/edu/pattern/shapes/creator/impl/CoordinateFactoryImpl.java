package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.CoordinateFactory;
import edu.pattern.shapes.model.Coordinate;

public class CoordinateFactoryImpl implements CoordinateFactory {

    @Override
    public Coordinate createCoordinate(double x, double y, double z) {
        return new Coordinate(x, y, z);
    }

    @Override
    public Coordinate[] createCoordinates(double[][] coordinates) {
        Coordinate[] coordinateArray = new Coordinate[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            double[] coordinate = coordinates[i];
            if (coordinate.length != 3) {
                throw new IllegalArgumentException("Each coordinate should have 3 values: x, y, and z");
            }
            coordinateArray[i] = createCoordinate(coordinate[0], coordinate[1], coordinate[2]);
        }
        return coordinateArray;
    }

}
