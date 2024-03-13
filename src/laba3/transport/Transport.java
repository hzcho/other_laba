package laba3.transport;

import laba3.exception.TransportException;
import laba3.exception.TransportRuntimeException;

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

//    void output(OutputStream out);
//    void write(Writer out);
}
