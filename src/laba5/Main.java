package laba5;

import laba5.other.StreamWorker;
import laba5.thread.*;
import laba5.transport.Bicycle;
import laba5.transport.Car;
import laba5.transport.Transport;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //#1
        Car car=new Car(10);
        FirstThread thread1=new FirstThread(car);
        SecondThread thread2=new SecondThread(car);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(" ");

        //#2
        int size=20;
        Car car2=new Car(size);
        TransportSynchronizer synchronizer=new TransportSynchronizer(car2);
        Thread thread3=new Thread(new FirstRunnable(synchronizer, size));
        Thread thread4=new Thread(new SecondRunnable(synchronizer, size));

        thread3.start();
        thread4.start();
    }
}