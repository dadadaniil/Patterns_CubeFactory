package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeService {
    private final static Logger logger = LogManager.getLogger();
    private static final int MULTIPLICATION_DEGREE = 3;
    private static final int SURFACE_AREA_MULTIPLIER = 6;
    private static final int SURFACE_MULTIPLICATION_DEGREE = 2;

    public double volume(Cube cube) {
        double pow = Math.pow(cube.getSideLength(), MULTIPLICATION_DEGREE);
        logger.info("Volume of cube with id " + cube.getId() + " is calculated" + " and is equal to " + pow);
        return pow;
    }

    public double surfaceArea(Cube cube) {
        double v = SURFACE_AREA_MULTIPLIER * Math.pow(cube.getSideLength(), CubeService.SURFACE_MULTIPLICATION_DEGREE);
        logger.info("Surface area of cube with id " + cube.getId() + " is calculated and is equal to " + v);
        return v;
    }
}
