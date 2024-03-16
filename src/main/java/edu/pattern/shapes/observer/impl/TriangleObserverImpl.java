package edu.pattern.shapes.observer.impl;

import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.model.TriangleState;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.TriangleObserver;
import edu.pattern.shapes.service.TriangleService;

public class TriangleObserverImpl implements TriangleObserver {
    @Override
    public void update(Triangle triangle) {
        TriangleState state = TriangleState.detect(triangle);
        TriangleService service = new TriangleService();
        double perimeter = service.perimeter(triangle);
        int key = triangle.getTriangleId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, perimeter);
    }
}
