package org.example;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Noapte bunam, copii!");
        Author author = new Author("Autorul", "Disparut");
        b1.addAuthors(author);

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");

        b1.addContents(new Paragraph("Multumesc celor care..."));
        b1.addContents(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);
        cap111.add(cap1111);
        cap1111.add(new Image("Image subchapter 1.1.1.1"));
        b1.print();
    }
}
