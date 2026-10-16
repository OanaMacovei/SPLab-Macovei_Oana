package org.example;

public class BookStatistics implements Visitor{
    public int nrImages = 0;
    public int nrTables = 0;
    public int nrParagraphs = 0;

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + nrImages);
        System.out.println("*** Number of Tables: " + nrTables);
        System.out.println("*** Number of Paragraphs: " + nrParagraphs);
    }

    @Override
    public void visit(Book b) {}

    @Override
    public void visit(Section section) {}

    @Override
    public void visit(TableOfContents tableOfContents) {}

    @Override
    public void visit(Paragraph p) {
        nrParagraphs++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        nrImages++;
    }

    @Override
    public void visit(Table t) {
        nrTables++;
    }
}
