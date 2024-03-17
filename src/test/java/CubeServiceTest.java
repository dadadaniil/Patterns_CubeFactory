import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.service.CubeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CubeServiceTest {

    CoordinateFactoryImpl factory = new CoordinateFactoryImpl();
    CubeService cubeService = new CubeService();

    private double[][] validCoordinates = {
            {0, 0, 0},
            {2, 2, 2},
            {2, 2, 0},
            {0, 0, 2},
            {2, 0, 0},
            {0, 2, 0},
            {2, 0, 2},
            {0, 2, 2}
    };

    @Test
    public void testVolumePositive() {
        Cube cube = new Cube(factory.createCoordinates(validCoordinates));
        assertEquals(8, cubeService.volume(cube));
    }

    @Test
    public void testSurfaceAreaPositive() {
        Cube cube = new Cube(factory.createCoordinates(validCoordinates));
        assertEquals(24, cubeService.surfaceArea(cube));
    }

    @Test
    public void testVolumeNegative() {
        Cube cube = new Cube(factory.createCoordinates(validCoordinates));
        assertNotEquals(10, cubeService.volume(cube));
    }

    @Test
    public void testSurfaceAreaNegative() {
        Cube cube = new Cube(factory.createCoordinates(validCoordinates));
        assertNotEquals(30, cubeService.surfaceArea(cube));
    }
}