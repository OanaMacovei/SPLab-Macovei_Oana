package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject implements Subject{
    public List<Observer> observers = new ArrayList<>();
    public Book lastAddedBook;

    @Override
    public void registerObserver(Observer ob) {
        this.observers.add(ob);
    }

    @Override
    public void unregisterObserver(Observer ob) {
        this.observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.lastAddedBook);
        }
    }

    public void add(Book book) {
        this.lastAddedBook = book;
        this.notifyObservers();
    }
}
