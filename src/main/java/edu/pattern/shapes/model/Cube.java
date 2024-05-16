package edu.pattern.shapes.model;

import edu.pattern.shapes.observer.CubeObserver;
import edu.pattern.shapes.observer.Observable;
import edu.pattern.shapes.observer.impl.CubeObserverImpl;
import edu.pattern.shapes.service.CoordinateService;
import edu.pattern.shapes.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.StringJoiner;

public class Cube implements Observable {
    private final static Logger logger = LogManager.getLogger();
    private static final int NUMBER_OF_CUBE_COORDINATES = 8;
    private static final String CUBE_COORDINATES_ERROR = "A cube must have 8 coordinates";

    private int id;
    private Coordinate[] coordinates;
    private CubeState state;
    private CubeObserver observer = new CubeObserverImpl();

    public Cube(Coordinate[] coordinates) {
        if (coordinates.length != NUMBER_OF_CUBE_COORDINATES) {
            logger.error(CUBE_COORDINATES_ERROR);
            throw new IllegalArgumentException("A cube must have 8 coordinates");
        }
        this.coordinates = CoordinateService.sortCoordinates(coordinates);
        this.id = IdGenerator.increment();
        this.state = CubeState.detect(this);
        logger.info("Cube with id " + id + " and coordinates" + Arrays.toString(coordinates) + " is created");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyObservers();
        logger.info("Id of cube with id " + id + " is changed");
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate[] coordinates) {
        this.coordinates = CoordinateService.sortCoordinates(coordinates);
        this.state = CubeState.detect(this);
        notifyObservers();
    }

    public CubeState getState() {
        return state;
    }

    public double getSideLength() {
        return CoordinateService.distanceBetweenCoordinates(coordinates[0], coordinates[1]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cube cube = (Cube) obj;
        return Arrays.asList(coordinates).equals(Arrays.asList(cube.getCoordinates()));
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(coordinates);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("coordinates=" + Arrays.toString(coordinates))
            .add("state=" + state)
            .toString();
    }

    @Override
    public void attach() {
        observer = new CubeObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }
}
