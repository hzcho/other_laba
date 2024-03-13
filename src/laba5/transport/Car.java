package laba5.transport;

import laba5.exception.TransportException;
import laba5.exception.TransportRuntimeException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class Car implements Transport, Serializable {
    private String model;
    private int price;
    private String[] features;
    private int[] array;

    public Car(){
        model="unknown";
        price=0;
        features=new String[]{ "nothing" };
    }
    public Car(String model, int price, String[] features){
        this.model=model;
        this.price=price;
        this.features=features;
    }
    public Car(String model, int price, int arraySize){
        this.model=model;
        this.price=price;
        this.features=new String[arraySize];
    }
    public Car(int size){
        array=new int[size];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
    public int getArrayItem(int index){
        return array[index];
    }
    public void setArrayItem(int index, int value){
        array[index]=value;
    }
    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model=model;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price=price;
    }

    @Override
    public String[] getFeatures() {
        return features;
    }

    @Override
    public void setFeatures(String[] features) {
        this.features=features;
    }

    @Override
    public String getFeaturesItem(int id) throws TransportException {
        if (id<0 || id>=features.length) {
            throw new TransportException("идекс за пределами массива");
        }
        return features[id];
    }

    @Override
    public void setFeaturesItem(int id, String value) throws TransportRuntimeException {
        try {
            features[id]=value;
        }catch (IllegalArgumentException err){
            throw new TransportRuntimeException("идекс за пределами массива", err);
        }
    }

    @Override
    public String transportInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Model: ").append(model).append("\n");
        sb.append("Price: ").append(price).append("\n");
        sb.append("Features:\n");
        for (String feature : features) {
            sb.append("- ").append(feature).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", features=" + Arrays.toString(features) +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, Arrays.hashCode(features));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return price == car.price &&
                Objects.equals(model, car.model) &&
                Arrays.equals(features, car.features);
    }

    @Override
    public void output(OutputStream out) throws IOException {
        try{
            StringBuilder dataBuilder = new StringBuilder();
            dataBuilder.append("Type:").append("Car").append(";");;
            dataBuilder.append("Model:").append(model).append(";");
            dataBuilder.append("Price:").append(price).append(";");
            dataBuilder.append("Features:");
            for (String feature : features) {
                dataBuilder.append(feature).append(",");
            }
            dataBuilder.append('\n');

            byte[] bytes = dataBuilder.toString().getBytes(StandardCharsets.UTF_8);

            out.write(bytes);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            out.close();
        }
    }

    @Override
    public void write(Writer out) throws IOException {
        try{
            StringBuilder dataBuilder = new StringBuilder();
            dataBuilder.append("Type:").append("Car").append(";");;
            dataBuilder.append("Model:").append(model).append(";");
            dataBuilder.append("Price:").append(price).append(";");
            dataBuilder.append("Features:");
            for (String feature : features) {
                dataBuilder.append(feature).append(",");
            }
            dataBuilder.append('\n');

            out.write(dataBuilder.toString());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            out.close();
        }
    }
}