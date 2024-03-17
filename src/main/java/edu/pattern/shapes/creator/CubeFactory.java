package edu.pattern.shapes.creator;

import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.model.Cube;

import java.util.List;

public interface CubeFactory {

    Cube createCube(Coordinate[] coordinates);

    List<Cube> createCubes(List<Coordinate[]> coordinates);
    List<Cube> createCubesFromFile(String filePath);

}
