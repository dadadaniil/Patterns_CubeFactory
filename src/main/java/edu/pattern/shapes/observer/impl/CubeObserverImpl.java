package edu.pattern.shapes.observer.impl;

import edu.pattern.shapes.model.Cube;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.CubeObserver;
import edu.pattern.shapes.service.CubeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CubeObserverImpl implements CubeObserver {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public void update(Cube cube) {
        CubeService service = new CubeService();
        double surfaceArea = service.surfaceArea(cube);
        int key = cube.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, surfaceArea);
        logger.info("Cube with id " + cube.getId() + " is updated with points " + Arrays.toString(cube.getCoordinates()) + " and surface area is " + surfaceArea);
    }
}
