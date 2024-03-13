package laba5.other;

import laba5.transport.Bicycle;
import laba5.transport.Car;
import laba5.transport.Transport;

import java.io.*;

public class StreamWorker {
    public static void outputTransport(Transport o, OutputStream out) throws IOException {
        o.output(out);
    }
    public Transport inputTransport(InputStream in) throws IOException{//костыль
        Transport transport = null;

        StringBuilder stringBuilder = new StringBuilder();
        int byteRead;
        while ((byteRead = in.read()) != -1) {
            stringBuilder.append((char) byteRead);
        }
        String[] transportInfo = stringBuilder.toString().split(";");
        String type=transportInfo[0].split(":")[1];
        String model=transportInfo[1].split(":")[1];
        int price=Integer.parseInt(transportInfo[2].split(":")[1]);
        String[] features=transportInfo[3].split(":")[1].split(",");

        if (type.equals("Car")){
            transport= new Car(model, price, features);
        }
        else if(type.equals("Bicycle")){
            transport= new Bicycle(model, price, features);
        }

        return transport;
    }
    public void writeTransport(Transport o, Writer out) throws IOException {
        o.write(out);
    }
    public Transport readTransport(Reader in) throws IOException{
        Transport transport = null;

        StringBuilder stringBuilder = new StringBuilder();
        int byteRead;
        while ((byteRead = in.read()) != -1) {
            stringBuilder.append((char) byteRead);
        }
        String[] transportInfo = stringBuilder.toString().split(",");
        String type=transportInfo[0].split(":")[1];
        String model=transportInfo[1].split(":")[1];
        int price=Integer.parseInt(transportInfo[2].split(":")[1]);
        String[] features=transportInfo[3].split(":")[1].split(",");

        if (type.equals("Car")){
            transport= new Car(model, price, features);
        }
        else if(type.equals("Bicycle")){
            transport= new Bicycle(model, price, features);
        }

        return transport;
    }

    public void serializeTransport(Transport transport, OutputStream out){
        try (ObjectOutputStream objectOut = new ObjectOutputStream(out)) {
            objectOut.writeObject(transport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Transport deserializeTransport(InputStream in){
        try (ObjectInputStream objectIn = new ObjectInputStream(in)) {
            return (Transport) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized Transport synchronizedTransport(Transport transport) {
        return new TransportWrapper(transport);
    }
}
