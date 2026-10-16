package org.example;

public interface Element {
    void render();
    void accept(Visitor visitor);
}
