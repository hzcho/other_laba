package laba6.transport;

import laba6.exception.TransportException;
import laba6.exception.TransportRuntimeException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public interface Transport extends Iterable {
    String getModel();
    void setModel(String model);
    int getPrice();
    void setPrice(int price);
    String[] getFeatures();
    void setFeatures(String[] features);
    String getFeaturesItem(int id) throws TransportException;
    void setFeaturesItem(int id, String value) throws TransportRuntimeException;
    String transportInfo();

    void output(OutputStream out) throws IOException;
    void write(Writer out) throws IOException;
    public int[] getArray();

    public void setArray(int[] array);
    public int getArrayItem(int index);
    public void setArrayItem(int index, int value);
}
