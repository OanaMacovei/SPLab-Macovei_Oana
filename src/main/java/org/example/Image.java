package org.example;

public class Image implements Element{
    String url;
    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + this.url);
    }
}
