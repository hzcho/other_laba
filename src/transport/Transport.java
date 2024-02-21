package transport;

import exception.TransportException;
import exception.TransportRuntimeException;

public interface Transport {
    String getModel();
    void setModel(String model);
    int getPrice();
    void setPrice(int price);
    String[] getFeatures();
    void setFeatures(String[] features);
    String getArrayItem(int id) throws TransportException;
    void setArrayItem(int id, String value) throws TransportRuntimeException;
    String transportInfo();
}
