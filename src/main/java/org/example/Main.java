package org.example;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Element img1 = new ImageProxy("Pamela Anderson");
        Element img2 = new ImageProxy("Kim Kardashian");
        Element img3 = new ImageProxy("Kirby Griffin");

        Section playboyS1 = new Section("Front Cover");
        playboyS1.add(img1);
        Section playboyS2 = new Section("Summer Girls");
        playboyS2.add(img2);
        playboyS2.add(img3);

        Book playboy = new Book("Playboy");
        playboy.addContents(playboyS1);
        playboy.addContents(playboyS2);

        long endTime = System.currentTimeMillis();
        System.out.println("Creation of the content took " + (endTime - startTime) + " milliseconds");
        
        startTime = System.currentTimeMillis();
        playboyS1.print();
        endTime = System.currentTimeMillis();
        System.out.println("Printing of the section 1 took " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        playboyS1.print();
        endTime = System.currentTimeMillis();

        System.out.println("Printing again the section 1 took " + (endTime - startTime) + " milliseconds");
    }
}
