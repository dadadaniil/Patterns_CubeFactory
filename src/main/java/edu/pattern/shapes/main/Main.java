package edu.pattern.shapes.main;

import edu.pattern.shapes.creator.CoordinateFactory;
import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import edu.pattern.shapes.creator.impl.CubeFactoryImpl;
import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.impl.CubeObserverImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CoordinateFactory factory = new CoordinateFactoryImpl();
        CubeFactoryImpl cubeFactory = new CubeFactoryImpl();
        List<Cube> cubes = cubeFactory.createCubesFromFile("/cubes.txt");

        Cube cube = cubes.get(0);
        System.out.println(cube);
        Warehouse warehouse = Warehouse.getInstance();
        CubeObserverImpl updater = new CubeObserverImpl();
        updater.update(cube);

        double[][] coordinatesArray = {
                {0, 0, 0},
                {2, 0, 0},
                {2, 2, 0},
                {0, 2, 0},
                {0, 0, 2},
                {2, 0, 2},
                {2, 2, 2},
                {0, 2, 2}
        };

        Coordinate[] newCoordinates = factory.createCoordinates(coordinatesArray);
        cube.setCoordinates(newCoordinates);
        System.out.println(warehouse);

    }
}