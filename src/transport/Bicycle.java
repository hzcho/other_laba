package transport;

import exception.TransportException;
import exception.TransportRuntimeException;

import javax.xml.transform.TransformerException;
import java.util.Arrays;
import java.util.Objects;

public class Bicycle implements Transport {
    private String model;
    private int price;
    private String[] features;

    public Bicycle(){
        model="unknown";
        price=0;
        features=new String[]{ "nothing" };
    }
    public Bicycle(String model, int price, String[] features){
        this.model=model;
        this.price=price;
        this.features=features;
    }
    public Bicycle(String model, int price, int arraySize){
        this.model=model;
        this.price=price;
        this.features=new String[arraySize];
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
    public String getArrayItem(int id) throws TransportException {
        if (id<0 || id>=features.length) {
            throw new TransportException("идекс за пределами массива");
        }
        return features[id];
    }

    @Override
    public void setArrayItem(int id, String value) throws TransportRuntimeException {
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
        return "Bicycle{" +
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
        Bicycle bicycle = (Bicycle) obj;
        return price == bicycle.price &&
                Objects.equals(model, bicycle.model) &&
                Arrays.equals(features, bicycle.features);
    }
}
