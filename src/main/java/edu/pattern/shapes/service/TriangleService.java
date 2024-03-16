package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.util.IdGenerator;
import org.apache.log4j.Logger;

public class TriangleService {
    private static final Logger logger = Logger.getLogger(TriangleService.class);

    public double perimeter(Triangle triangle) {
        logger.info("Perimeter of triangle with id " + triangle.getTriangleId() + " is calculated");
        return triangle.getA() + triangle.getC() + triangle.getB();//todo
    }
}
