package org.example;

public interface Subject {
    void registerObserver(Observer ob);
    void unregisterObserver(Observer ob);
    void notifyObservers();
}
