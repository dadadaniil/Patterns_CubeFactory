import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.service.CoordinateService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordinateServiceTest {

    @Test
    public void testSortCoordinates() {
        Coordinate[] coordinates = new Coordinate[]{
                new Coordinate(1, 1, 3),
                new Coordinate(2, 2, 2),
                new Coordinate(3, 3, 1)
        };
        Coordinate[] sortedCoordinates = CoordinateService.sortCoordinates(coordinates);
        double x = sortedCoordinates[1].getX();
        double x1 = sortedCoordinates[2].getX();
        assertTrue(x < x1);
    }

    @Test
    public void testDistanceBetweenCoordinates() {
        Coordinate coordinate1 = new Coordinate(1, 1, 1);
        Coordinate coordinate2 = new Coordinate(2, 2, 2);
        double distance = CoordinateService.distanceBetweenCoordinates(coordinate1, coordinate2);
        assertEquals(Math.sqrt(3), distance);
    }

    @Test
    public void testSortCoordinatesNegativeSecondCoordinate() {
        Coordinate[] coordinates = new Coordinate[]{
                new Coordinate(1, 1, 3),
                new Coordinate(2, 2, 2),
                new Coordinate(3, 3, 1)
        };
        Coordinate[] sortedCoordinates = CoordinateService.sortCoordinates(coordinates);
        assertEquals(2, sortedCoordinates[1].getZ());
    }

    @Test
    public void testDistanceBetweenCoordinatesNegative() {
        Coordinate coordinate1 = new Coordinate(1, 1, 1);
        Coordinate coordinate2 = new Coordinate(2, 2, 2);
        double distance = CoordinateService.distanceBetweenCoordinates(coordinate1, coordinate2);
        assertNotEquals(4, distance);
    }

    @Test
    public void testDistanceBetweenCoordinatesNegativeSecond() {
        Coordinate coordinate1 = new Coordinate(1, 1, 1);
        Coordinate coordinate2 = new Coordinate(2, 2, 2);
        double distance = CoordinateService.distanceBetweenCoordinates(coordinate1, coordinate2);
        assertNotEquals(4, distance);
    }

}