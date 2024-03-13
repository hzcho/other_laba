package laba6.transport;

public class BicycleFactory implements TransportFactory{
    @Override
    public Transport createInstance() {
        return new Bicycle();
    }
}
