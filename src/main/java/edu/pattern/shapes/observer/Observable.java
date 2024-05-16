package edu.pattern.shapes.observer;

public interface Observable {
    void attach();

    void detach();

    void notifyObservers();
}
