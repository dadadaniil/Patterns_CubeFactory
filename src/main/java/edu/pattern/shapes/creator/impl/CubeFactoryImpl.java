package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.CubeFactory;
import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.model.Cube;

import java.util.ArrayList;
import java.util.List;

public class CubeFactoryImpl implements CubeFactory {

    @Override
    public Cube createCube(Coordinate[] coordinates) {
        Cube cube = new Cube(coordinates);
        return cube;
    }

    @Override
    public List<Cube> createCubes(List<Coordinate[]> coordinates) {
        List<Cube> cubes = new ArrayList<>();
        for (Coordinate[] coordinate : coordinates) {
            cubes.add(new Cube(coordinate));
        }
        return cubes;
    }

}
