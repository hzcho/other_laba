package laba5.other;

import laba5.exception.TransportException;
import laba5.exception.TransportRuntimeException;
import laba5.transport.Transport;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class TransportWrapper implements Transport {
    private Transport transport;

    public TransportWrapper(Transport transport){
        this.transport=transport;
    }
    @Override
    synchronized public String getModel() {
        return transport.getModel();
    }

    @Override
    synchronized public void setModel(String model) {
        transport.setModel(model);
    }

    @Override
    synchronized public int getPrice() {
        return transport.getPrice();
    }

    @Override
    synchronized public void setPrice(int price) {
        transport.setPrice(price);
    }

    @Override
    synchronized public String[] getFeatures() {
        return transport.getFeatures();
    }

    @Override
    synchronized public void setFeatures(String[] features) {
        transport.setFeatures(features);
    }

    @Override
    synchronized public String getFeaturesItem(int id) throws TransportException {
        return transport.getFeaturesItem(id);
    }

    @Override
    synchronized public void setFeaturesItem(int id, String value) throws TransportRuntimeException {
        transport.setFeaturesItem(id, value);
    }

    @Override
    synchronized public String transportInfo() {
        return transport.transportInfo();
    }

    @Override
    synchronized public void output(OutputStream out) throws IOException {
        transport.output(out);
    }

    @Override
    synchronized public void write(Writer out) throws IOException {
        transport.write(out);
    }

    @Override
    synchronized public int[] getArray() {
        return transport.getArray();
    }

    @Override
    synchronized public void setArray(int[] array) {
        transport.setArray(array);
    }

    @Override
    synchronized public int getArrayItem(int index) {
        return transport.getArrayItem(index);
    }

    @Override
    synchronized public void setArrayItem(int index, int value) {
        transport.setArrayItem(index, value);
    }
}
