package edu.pattern.shapes.main;

import edu.pattern.shapes.creator.CoordinateFactory;
import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import edu.pattern.shapes.creator.impl.CubeFactoryImpl;
import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.model.CubeState;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.impl.CubeObserverImpl;

public class Main {
    public static void main(String[] args) {
        CoordinateFactory factory = new CoordinateFactoryImpl();

        double[][] coordinatesArray = {
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 1},
                {1, 1, 1},
                {0, 1, 1}
        };
        Coordinate[] coordinates = factory.createCoordinates(coordinatesArray);

        CubeFactoryImpl cubeFactory = new CubeFactoryImpl();
        Cube cube = cubeFactory.createCube(coordinates);

        Warehouse warehouse = Warehouse.getInstance();
        CubeObserverImpl updater = new CubeObserverImpl();
        updater.update(cube);

        double[][] coordinatesArray1 = {
                {0, 0, 0},
                {2, 0, 0},
                {2, 2, 0},
                {0, 2, 0},
                {0, 0, 2},
                {2, 0, 2},
                {2, 2, 2},
                {0, 2, 2}
        };

        Coordinate[] newCoordinates = factory.createCoordinates(coordinatesArray1);
        cube.setCoordinates(newCoordinates);
        System.out.println(warehouse);

    }
}