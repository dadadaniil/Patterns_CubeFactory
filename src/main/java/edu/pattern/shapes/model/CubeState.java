package edu.pattern.shapes.model;

import edu.pattern.shapes.service.CoordinateService;
import org.apache.log4j.Logger;

public enum CubeState {
    REGULAR, INVALID;
    private static final Logger logger = Logger.getLogger(CubeState.class);


    public static CubeState detect(Cube cube) {
        Coordinate[] coordinates = cube.getCoordinates();
        Coordinate[] sortedCoordinates = CoordinateService.sortCoordinates(coordinates);
        double[] lengths = new double[12];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            lengths[index++] = CoordinateService.distanceBetweenCoordinates(sortedCoordinates[i], sortedCoordinates[(i + 1) % 4]);
        }
        for (int i = 4; i < 8; i++) {
            lengths[index++] = CoordinateService.distanceBetweenCoordinates(sortedCoordinates[i], sortedCoordinates[((i - 4) + 1) % 4 + 4]);
        }
        for (int i = 0; i < 4; i++) {
            lengths[index++] = CoordinateService.distanceBetweenCoordinates(sortedCoordinates[i], sortedCoordinates[i + 4]);
        }

        double length = lengths[0];
        for (double l : lengths) {
            if (Math.abs(l - length) > 1e-6) {
                logger.info("Cube with id " + cube.getId() + " is invalid");
                return INVALID;
            }
        }
        logger.info("Cube with id " + cube.getId() + " is regular");
        return REGULAR;
    }
}
