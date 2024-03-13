package laba6;

import laba6.thread.*;
import laba6.transport.Car;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car("Toyota", 20000, new String[]{"GPS", "bluetooth", "iechestoto"});

        for (Object feature : car) {
            System.out.println(feature);
        }
    }
}