package org.example;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element{
    public List<String> entries = new ArrayList<>();

    public void addEntry(String entry) {
        this.entries.add(entry);
    }

    public List<String> getEntries() {
        return this.entries;
    }


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
