package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Entity
@Getter
@Setter
public class ImageProxy extends BaseElement implements Picture{
    String url;
    Dimension dim;

    @Transient
    Image realImage;

    public ImageProxy(String url) {
        this.url = url;
    }

    public ImageProxy() {}

    @Override
    public String url() {
        return this.url;
    }

    @Override
    public Dimension dim() {
        return this.dim;
    }

    @Override
    public ImageContent content() {
        return loadImage().content;
    }

    public Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    public void render() {
        loadImage().render();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
