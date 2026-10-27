package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    String title;
    @Getter
    List<Element> elements = new ArrayList<>();
    public Section(String title) {
        this.title = title;
    }

    public Section() {}

    public List<Element> getElements() {
        return elements;
    }

    public void add(Element element) {
        this.elements.add(element);
    }

    public void remove(Element element) {
        this.elements.remove(element);
    }

    @Override
    public void render() {
        System.out.println(this.title);
        for (Element element : elements) {
            element.render();
        }
   }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
