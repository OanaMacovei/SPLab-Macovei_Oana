package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Access(AccessType.FIELD)
public class Section extends BaseElement {
    String title;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type",
            defaultImpl = Paragraph.class
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Paragraph.class, name = "paragraph"),
            @JsonSubTypes.Type(value = Section.class, name = "section"),
            @JsonSubTypes.Type(value = ImageProxy.class, name = "image_proxy"),
            @JsonSubTypes.Type(value = Table.class, name = "table")
    })
    List<Element> elements = new ArrayList<>();
    public Section(String title) {
        this.title = title;
    }

    public Section() {}

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void add(Element element) {
        this.elements.add(element);
    }

    public void remove(Element element) {
        this.elements.remove(element);
    }

    @Override
    public void render() {
        System.out.println(this.title);
        for (Element element : elements) {
            element.render();
        }
   }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
