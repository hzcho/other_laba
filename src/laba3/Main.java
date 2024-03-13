package laba3;

import laba3.transport.Bicycle;
import laba3.transport.Car;
import laba3.transport.Transport;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Transport> transports = new ArrayList<>();
        ArrayList<Transport> transportSameResult = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Bicycle> bicycles = new ArrayList<>();

        transports.add(new Car("Toyota", 20000, new String[]{"GPS", "Air Conditioning"}));
        transports.add(new Bicycle("BMX", 500, new String[]{"Steel Frame", "Disc Brakes"}));
        transports.add(new Car("Honda", 18000, new String[]{"Bluetooth", "Sunroof"}));
        transports.add(new Bicycle("Mountain Bike", 800, new String[]{"Front Suspension", "Aluminum Frame"}));
        transports.add(new Car("Honda", 18000, new String[]{"Bluetooth", "Sunroof"}));

        System.out.println("full information");
        for (Transport transport : transports) {
            System.out.println(transport.transportInfo());
        }

        //System.out.println("\n laba3.transport with the same result transportInfo");
        for (int i = 0; i < transports.size(); i++) {
            for (int j = i + 1; j < transports.size(); j++) {
                if(transports.get(i).transportInfo().equals(transports.get(j).transportInfo())){
                    transportSameResult.add(transports.get(i));
                    transportSameResult.add(transports.get(j));
                }
            }
        }

        for (Transport transport : transports){
            if (transport instanceof Car){
                cars.add((Car) transport);
            }
            else if (transport instanceof Bicycle){
                bicycles.add((Bicycle) transport);
            }
        }

        System.out.println("full information of transportSameResult");
        for (Transport transport : transportSameResult){
            System.out.println(transport.transportInfo());
        }

        System.out.println("full information of cars");
        for (Car car : cars){
            System.out.println(car.transportInfo());
        }

        System.out.println("full information of bicycle");
        for (Bicycle bicycle : bicycles){
            System.out.println(bicycle.transportInfo());
        }
    }

    public static int test(int num) throws Exception{
        if(num<1) throw new Exception("The number is less than 1");
        int result=1;
        for(int i=1; i<=num;i++){

            result*=i;
        }
        return result;
    }
}