package week7.timeRandomApp;

import week7.numberApp.*;
import week7.timeApp.*;

public class CurrentTimeRandomNumberApp {

    public static void main(String[] args) {

        // Create Runnable object
        Runnable randomNumberTask1 = new RandomNumberTask(1, 100);
        Runnable randomNumberTask2 = new RandomNumberTask(5, 50);

        Runnable currentTime1 = new CurrentTimeTask();

        // Create Thread object

        Thread thread1 = new Thread(randomNumberTask1);
        Thread thread2 = new Thread(randomNumberTask2);
        Thread thread3 = new Thread(currentTime1);

        // Start Thread
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
