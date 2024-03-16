package edu.pattern.shapes.observer;

import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.model.Triangle;

public interface CubeObserver {
    void update(Cube cube);

}
