package org.example;

public class Table implements Element{
    String attributes;

    public Table(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public void render() {
        System.out.println("Table attributes: " + this.attributes);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
