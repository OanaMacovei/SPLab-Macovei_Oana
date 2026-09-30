package org.example;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    String title;
    List<Element> elements = new ArrayList<>();
    public Section(String title) {
        this.title = title;
    }

    public void add(Element element) {
        this.elements.add(element);
    }

    public void remove(Element element) {
        this.elements.remove(element);
    }

   @Override
    public void print() {
        System.out.println(this.title);
        for (Element element : elements) {
            element.print();
        }
   }
}
