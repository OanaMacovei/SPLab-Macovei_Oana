package org.example;

import java.util.concurrent.TimeUnit;

public class Image implements Element{
    String url;
    ImageContent content;

    public Image(String name) {
        this.url = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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
