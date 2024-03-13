package laba6.transport;

public class CarFactory implements TransportFactory{
    @Override
    public Transport createInstance() {
        return new Car();
    }
}
