package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.concurrent.TimeUnit;

@Entity
public class Image extends BaseElement{
    String url;

    @Transient
    ImageContent content;

    public Image(String name) {
        this.url = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Image() {}

    public ImageContent content() {
        return this.content;
    }

    @Override
    public void render() {
        System.out.println("Image with name: " + this.url);
    }

    @Override
    public void accept(Visitor visitor) {}
}
