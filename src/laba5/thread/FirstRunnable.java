package laba5.thread;

public class FirstRunnable implements Runnable{
    TransportSynchronizer synchronizer;
    int array_size=0;
    public FirstRunnable(TransportSynchronizer synchronizer, int array_size){
        this.synchronizer=synchronizer;
        this.array_size=array_size;
    }
    @Override
    public void run() {
        try {
            for (int i=0; i<array_size; i++) {
                synchronizer.write(12);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
