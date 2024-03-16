package edu.pattern.shapes.model;

import edu.pattern.shapes.observer.Observable;
import edu.pattern.shapes.observer.TriangleObserver;
import edu.pattern.shapes.observer.impl.TriangleObserverImpl;
import edu.pattern.shapes.util.IdGenerator;

import java.util.StringJoiner;

public class Triangle implements Observable {
    private int triangleId;
    private double a;
    private double b;
    private double c;
    private TriangleState state = TriangleState.INVALID;

    private TriangleObserver observer = new TriangleObserverImpl();

    public Triangle(double a, double b, double c) {
        triangleId = IdGenerator.increment();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getTriangleId() {
        return triangleId;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
        notifyObservers();
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
        notifyObservers();
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
        notifyObservers();
    }

    public TriangleState getState() {
        return state;
    }

    public void setState(TriangleState state) {
        if (state != null) {
            this.state = state;
        }
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (triangleId != triangle.triangleId) return false;
        if (Double.compare(a, triangle.a) != 0) return false;
        if (Double.compare(b, triangle.b) != 0) return false;
        if (Double.compare(c, triangle.c) != 0) return false;
        return state == triangle.state;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = triangleId;
        temp = Double.doubleToLongBits(a);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + state.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Triangle.class.getSimpleName() + "[", "]")
                .add("id=" + triangleId)
                .add("a=" + a)
                .add("b=" + b)
                .add("c=" + c)
                .add("state=" + state)
                .toString();
    }


    @Override
    public void attach() {
        observer = new TriangleObserverImpl();
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
