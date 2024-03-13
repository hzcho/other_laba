package laba6.thread;

import laba6.transport.Transport;

import java.util.concurrent.ThreadLocalRandom;

public class FirstThread extends Thread{
    Transport transport;

    public FirstThread(Transport transport){
        this.transport=transport;
    }

    @Override
    public void run() {
       synchronized (transport){
           for (int i=0; i<transport.getArray().length; i++){
               int value = ThreadLocalRandom.current().nextInt(1,100);
               transport.setArrayItem(i, value);
               System.out.println("Write: " + value + " to position " + i);
           }
       }
    }
}
