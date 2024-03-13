package laba5.thread;

import laba5.transport.Transport;

public class TransportSynchronizer {
    private Transport i;
    private volatile int current = 0;
    private Object lock = new Object();
    private boolean set = false;

    public TransportSynchronizer(Transport i) {
        this.i = i;
    }

    public double read() throws InterruptedException {
        int val;
        synchronized(lock) {
            if (!canRead()) throw new InterruptedException();
            while (!set)
                lock.wait();
            val = i.getArrayItem(current++);
            System.out.println("Read: " + val);
            set = false;
            lock.notifyAll();
        }
        return val;
    }

    public void write(int val) throws InterruptedException {
        synchronized(lock) {
            if (!canWrite()) throw new InterruptedException();
            while (set)
                lock.wait();
            i.setArrayItem(current, val);
            System.out.println("Write: " + val);
            set = true;
            lock.notifyAll();
        }
    }

    public boolean canRead() {
        return current < i.getArray().length;
    }

    public boolean canWrite() {
        return (!set && current < i.getArray().length) || (set && current < i.getArray().length - 1);
    }

}
