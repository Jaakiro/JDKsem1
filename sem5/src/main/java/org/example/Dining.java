package org.example;

import java.util.concurrent.Semaphore;

public class Dining {

    private static final int NUM_PHILOSOPHERS = 5;

    private static final int MEALS = 3;

    private final Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS]; // массив вилок

    public Dining() {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1); // 1 вилка - 1 философ
        }
    }

    public void startDinner() {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            final int philosopher = i;
            new Thread(() -> dine(philosopher)).start();
        }
    }

    private void dine(int philosopher) {
        for (int i = 0; i < MEALS; i++) {
            think(philosopher);
            eat(philosopher);
        }
    }

    private void think(int philosopher) {
        System.out.println("Философ " + philosopher + " размышляет...");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void eat(int philosopher) {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % NUM_PHILOSOPHERS;

        try {
            if (philosopher % 2 == 0) {
                forks[rightFork].acquire(); // четный философ с правой вилкой
                forks[leftFork].acquire(); // с левой вилкой
            } else {
                forks[leftFork].acquire(); // нечетный философ с левой вилкой
                forks[rightFork].acquire(); // с правой вилкой
            }

            System.out.println("Философ " + philosopher + " ест...");
            Thread.sleep((long) (Math.random() * 1000));

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // вилки на место
            forks[leftFork].release();
            forks[rightFork].release();
        }
    }

    public static void main(String[] args) {
        Dining philosophers = new Dining();
        philosophers.startDinner();
    }
}
