package org.example;

import lombok.Getter;

public class GenerateToc implements Visitor {
    @Getter
    public TableOfContents toc = new TableOfContents();
    public int index = 1;

    @Override
    public void visit(Book b) {

    }

    @Override
    public void visit(Section section) {
        toc.addEntry(section.title + " ........... page " + index);
    }

    @Override
    public void visit(TableOfContents tableOfContents) {}

    @Override
    public void visit(Paragraph p) {
        index++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        index++;
    }

    @Override
    public void visit(Table t) {
        index++;
    }
}
