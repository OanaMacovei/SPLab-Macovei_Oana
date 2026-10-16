package org.example;

import java.awt.*;

public class ImageProxy implements Picture, Element{
    String url;
    Dimension dim;
    Image realImage;

    public ImageProxy(String url) {
        this.url = url;
    }

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
