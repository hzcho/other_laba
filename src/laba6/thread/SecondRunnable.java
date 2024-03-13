package laba6.thread;

public class SecondRunnable implements Runnable{
    TransportSynchronizer synchronizer;
    int array_size=0;
    public SecondRunnable(TransportSynchronizer synchronizer, int array_size){
        this.synchronizer=synchronizer;
        this.array_size=array_size;
    }
    @Override
    public void run() {
        try {
            for (int i=0; i<array_size; i++) {
                synchronizer.read();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
