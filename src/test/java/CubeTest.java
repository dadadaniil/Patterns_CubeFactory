import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import edu.pattern.shapes.model.Cube;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeTest {

    CoordinateFactoryImpl factory = new CoordinateFactoryImpl();


    private double[][] validCoordinates = {
            {0, 0, 0},
            {2, 0, 0},
            {2, 2, 0},
            {0, 2, 0},
            {0, 0, 2},
            {2, 0, 2},
            {2, 2, 2},
            {0, 2, 2}
    };

    @Test
    public void testSetCoordinatesPositive() {
        Cube cube = new Cube(factory.createCoordinates(validCoordinates));
        assertEquals(2, cube.getSideLength());
    }
}