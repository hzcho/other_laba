package laba6.other;

import laba6.exception.TransportException;
import laba6.exception.TransportRuntimeException;
import laba6.transport.Transport;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class UnmodifiableTransportWrapper implements Transport {
    private final Transport transport;

    public UnmodifiableTransportWrapper(Transport transport){
        this.transport=transport;
    }
    @Override
    public String getModel() {
        return transport.getModel();
    }

    @Override
    public void setModel(String model) {
        throw new UnsupportedOperationException("Cannot modify");
    }

    @Override
    public int getPrice() {
        return transport.getPrice();
    }

    @Override
    public void setPrice(int price) {
        throw new UnsupportedOperationException("Cannot modify");
    }

    @Override
    public String[] getFeatures() {
        return transport.getFeatures();
    }

    @Override
    public void setFeatures(String[] features) {
        throw new UnsupportedOperationException("Cannot modify");
    }

    @Override
    public String getFeaturesItem(int id) throws TransportException {
        return transport.getFeaturesItem(id);
    }

    @Override
    public void setFeaturesItem(int id, String value) throws TransportRuntimeException {
        throw new UnsupportedOperationException("Cannot modify");
    }

    @Override
    public String transportInfo() {
        return transport.transportInfo();
    }

    @Override
    public void output(OutputStream out) throws IOException {
        transport.output(out);
    }

    @Override
    public void write(Writer out) throws IOException {
        transport.write(out);
    }

    @Override
    public int[] getArray() {
        return transport.getArray();
    }

    @Override
    public void setArray(int[] array) {
        throw new UnsupportedOperationException("Cannot modify");
    }

    @Override
    public int getArrayItem(int index) {
        return transport.getArrayItem(index);
    }

    @Override
    public void setArrayItem(int index, int value) {
        throw new UnsupportedOperationException("Cannot modify");
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return transport.iterator();
    }
}
