package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.util.IdGenerator;
import org.apache.log4j.Logger;

public class CubeService {
    private static final Logger logger = Logger.getLogger(CubeService.class);

    public double volume(Cube cube) {
        double pow = Math.pow(cube.getSideLength(), 3);
        logger.info("Volume of cube with id " + cube.getId() + " is calculated" + " and is equal to " + pow);
        return pow;
    }

    public double surfaceArea(Cube cube) {

        double v = 6 * Math.pow(cube.getSideLength(), 2);
        logger.info("Surface area of cube with id " + cube.getId() + " is calculated" + " and is equal to " + v);
        return v;

    }
}
