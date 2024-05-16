package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.CoordinateFactory;
import edu.pattern.shapes.model.Coordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoordinateFactoryImpl implements CoordinateFactory {
    private final static Logger logger = LogManager.getLogger();
    private static final int REQUIRED_AMOUNT_OF_SIDES = 3;
    private static final int CUBE_SIDES_AMOUNT = 8;
    private static final String COORDINATES_SPLITTER = ";";
    private static final String DOTS_SPLITTER = ",";
    private static final int FIRST_COORDINATE = 0;
    private static final int SECOND_COORDINATE = 1;
    private static final int THIRD_COORDINATE = 2;
    private static final int COORDINATES_AMOUNT = 3;
    private static final int SIDES_AMOUNT = 8;
    private static final String EXCEPTION_MESSAGE = "Each coordinate should have 3 values: x, y, and z";

    @Override
    public Coordinate createCoordinate(double x, double y, double z) {
        return new Coordinate(x, y, z);
    }

    @Override
    public Coordinate[] createCoordinates(double[][] coordinates) {
        Coordinate[] coordinateArray = new Coordinate[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            double[] coordinate = coordinates[i];
            if (coordinate.length != REQUIRED_AMOUNT_OF_SIDES) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
            coordinateArray[i] = createCoordinate(coordinate[0], coordinate[1], coordinate[2]);
        }
        return coordinateArray;
    }

    @Override
    public Coordinate[] createCoordinates(String line) {
        String[] stringCoordinates = line.split(COORDINATES_SPLITTER);
        Coordinate[] coordinates = new Coordinate[CUBE_SIDES_AMOUNT];
        for (int i = 0; i < SIDES_AMOUNT; i++) {
            String[] xyz = stringCoordinates[i].split(DOTS_SPLITTER);
            if (xyz.length == COORDINATES_AMOUNT) {
                try {
                    double x = Double.parseDouble(xyz[FIRST_COORDINATE]);
                    double y = Double.parseDouble(xyz[SECOND_COORDINATE]);
                    double z = Double.parseDouble(xyz[THIRD_COORDINATE]);
                    coordinates[i] = new Coordinate(x, y, z);
                } catch (NumberFormatException e) {
                    logger.error("Invalid cube coordinates");
                }
            }
        }
        return coordinates;
    }

}
