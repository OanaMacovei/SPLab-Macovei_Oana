package org.example;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TableOfContents extends BaseElement{
    @ElementCollection
    public List<String> entries = new ArrayList<>();

    public void addEntry(String entry) {
        this.entries.add(entry);
    }

    public List<String> getEntries() {
        return this.entries;
    }

    public TableOfContents() {}

    @Override
    public void render() {
        System.out.println("Table of Contents:");
        for (String entry : this.entries) {
            System.out.println(entry);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
