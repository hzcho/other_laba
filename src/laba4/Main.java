package laba4;

import laba4.other.StreamWorker;
import laba4.transport.Bicycle;
import laba4.transport.Car;
import laba4.transport.Transport;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Transport transport = null;
        StreamWorker streamClass = new StreamWorker();

        System.out.println("Выберите тип элемента (Car или Bicycle):");
        String elementType = scanner.nextLine();

        System.out.println("Введите модель:");
        String model = scanner.nextLine();

        System.out.println("Введите цену:");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите особенности (через запятую):");
        String featuresString = scanner.nextLine();
        String[] features = featuresString.split(",");

        if (elementType.equalsIgnoreCase("Car")) {
            transport = new Car(model, price, features);
        } else if (elementType.equalsIgnoreCase("Bicycle")) {
            transport = new Bicycle(model, price, features);
        } else {
            System.out.println("Неподдерживаемый тип элемента.");
            System.exit(1);
        }

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            streamClass.outputTransport(transport, outputStream);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            Transport deserializedTransport = streamClass.inputTransport(inputStream);
            System.out.println("Десериализованный транспорт: " + deserializedTransport.transportInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("transport.ser");
            streamClass.serializeTransport(transport, fileOutputStream);
            FileInputStream fileInputStream = new FileInputStream("transport.ser");
            Transport deserializedTransport = streamClass.deserializeTransport(fileInputStream);
            System.out.println("Десериализованный транспорт: " + deserializedTransport.transportInfo());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}