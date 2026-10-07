package org.example;

public class AlignRight implements AlignStrategy{
    @Override
    public void render(Paragraph p, int context) {
        int length_p = p.getLength(p.getText());
        int space = context - length_p;
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(p.getText());
    }
}
