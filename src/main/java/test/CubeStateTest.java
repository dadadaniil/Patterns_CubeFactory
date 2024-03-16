package test;


import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.model.CubeState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeStateTest {

    CoordinateFactoryImpl factory = new CoordinateFactoryImpl();
    private double[][] firstSetOfCoordinates = {
            {0, 0, 0},
            {1, 0, 0},
            {1, 1, 0},
            {0, 1, 0},
            {0, 0, 1},
            {1, 0, 1},
            {1, 1, 1},
            {0, 1, 1}
    };
    double[][] secondSetCoordinates = {
            {0, 0, 0},
            {1, 1, 2},
            {1, 0, 1},
            {0, 1, 0},
            {0, 0, 1},
            {1, 0, 0},
            {1, 1, 1},
            {0, 1, 1}
    };
    double[][] thirdSetCoordinates = {
            {0, 0, 0},
            {0, 2, 0},
            {2, 0, 0},
            {0, 0, 1},
            {2, 2, 0},
            {2, 0, 1},
            {2, 2, 1},
            {0, 2, 1}
    };

    @Test
    public void testDetectRegularCube() {
        Cube cube = new Cube(factory.createCoordinates(firstSetOfCoordinates));
        assertEquals(CubeState.REGULAR, CubeState.detect(cube));
    }

    @Test
    public void testDetectRegularCubeOneWrongPoint() {
        Cube cube = new Cube(factory.createCoordinates(secondSetCoordinates));
        assertEquals(CubeState.INVALID, CubeState.detect(cube));
    }

    @Test
    public void testDetectInvalidCube() {
        Cube cube = new Cube(factory.createCoordinates(thirdSetCoordinates));
        assertEquals(CubeState.INVALID, CubeState.detect(cube));
    }
}