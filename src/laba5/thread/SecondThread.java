package laba5.thread;

import laba5.transport.Transport;

public class SecondThread extends Thread{
    Transport transport;

    public SecondThread(Transport transport){
        this.transport=transport;
    }

    @Override
    public void run() {
        synchronized (transport){
            for (int i=0; i<transport.getArray().length; i++){
                int value = transport.getArrayItem(i);
                System.out.println("Read: " + value + " from position " + i);
            }
        }
    }
}
