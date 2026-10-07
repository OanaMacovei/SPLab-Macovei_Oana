package org.example;


public class AlignLeft implements AlignStrategy{
    @Override
    public void render(Paragraph p, int context) {
        System.out.println(p.getText());
    }
}
