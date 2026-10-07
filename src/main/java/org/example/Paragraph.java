package org.example;

public class Paragraph implements Element {
    String text;
    AlignStrategy textAlignment;
    public Paragraph(String text) {
        this.text = text;
    }

    public int getLength(String text) {
        return text.length();
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignment) {
        this.textAlignment = alignment;
    }


    @Override
    public void print() {
        if (this.textAlignment != null) {
            this.textAlignment.render(this, 30);
        }
        else {
            System.out.println("Paragraph: " + this.text);
        }
    }
}
