package org.example;

public class RenderContentVisitor implements Visitor {

    @Override
    public void visit(Book b) {
        b.render();
    }

    @Override
    public void visit(Section section) {
        section.render();
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        tableOfContents.render();
    }

    @Override
    public void visit(Paragraph p) {
        p.render();
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        imageProxy.render();
    }

    @Override
    public void visit(Table t) {
        t.render();
    }
}
