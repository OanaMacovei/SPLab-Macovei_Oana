package org.example;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
public class Paragraph extends BaseElement {
    String text;

    @Transient
    AlignStrategy textAlignment;
    public Paragraph(String text) {
        this.text = text;
    }

    public Paragraph() {}

    public int getLength(String text) {
        return text.length();
    }

    public void setAlignStrategy(AlignStrategy alignment) {
        this.textAlignment = alignment;
    }


    @Override
    public void render() {
        if (this.textAlignment != null) {
            this.textAlignment.render(this, 30);
        }
        else {
            System.out.println("Paragraph: " + this.text);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit( this);
    }
}
