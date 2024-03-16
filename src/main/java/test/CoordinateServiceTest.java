package test;

import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.service.CoordinateService;
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
        assertTrue(sortedCoordinates[1].getZ() <= sortedCoordinates[2].getZ());
    }

    @Test
    public void testSortCoordinatesNegativeFirstCoordinate() {
        Coordinate[] coordinates = new Coordinate[]{
                new Coordinate(1, 1, 3),
                new Coordinate(2, 2, 2),
                new Coordinate(3, 3, 1)
        };
        Coordinate[] sortedCoordinates = CoordinateService.sortCoordinates(coordinates);
        assertNotEquals(3, sortedCoordinates[0].getZ());
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
    public void testSortCoordinatesNegativeThirdCoordinate() {
        Coordinate[] coordinates = new Coordinate[]{
                new Coordinate(1, 1, 3),
                new Coordinate(2, 2, 2),
                new Coordinate(3, 3, 1)
        };
        Coordinate[] sortedCoordinates = CoordinateService.sortCoordinates(coordinates);
        assertNotEquals(1, sortedCoordinates[2].getZ());
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