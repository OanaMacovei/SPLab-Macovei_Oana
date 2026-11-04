package org.example;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@jakarta.persistence.Table(name = "book_tables")
public class Table extends BaseElement{
    String attributes;

    public Table(String attributes) {
        this.attributes = attributes;
    }

    public Table() {}

    @Override
    public void render() {
        System.out.println("Table attributes: " + this.attributes);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
