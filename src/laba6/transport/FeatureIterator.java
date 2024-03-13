package laba6.transport;

import java.util.Iterator;
import java.util.NoSuchElementException;

class FeatureIterator implements Iterator<String> {
    private int currentIndex = 0;
    private String[] features;

    public FeatureIterator(String[] features) {
        this.features = features;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < features.length;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return features[currentIndex++];
    }
}
