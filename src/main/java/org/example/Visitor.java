package org.example;

public interface Visitor {
    void visit(Book b);
    void visit(Section section);
    void visit(TableOfContents tableOfContents);
    void visit(Paragraph p);
    void visit(ImageProxy imageProxy);
    void visit(Table t);
}
