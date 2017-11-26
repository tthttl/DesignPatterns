package structural.adapter_wrapsandconvertstheoldobject;

//aim is that two separate classes could work together
//possible to use abstract class instead of interface
//current implementation is object adapter, because of composition. its possible to use inheritance instead => class adapter
/*
Adapter makes things work after they're designed; Bridge makes them work before they are.
Bridge is designed up-front to let the abstraction and the implementation vary independently. Adapter is retrofitted to make unrelated classes work together.
Adapter provides a different interface to its subject. Proxy provides the same interface. Decorator provides an enhanced interface.
Adapter is meant to change the interface of an existing object. Decorator enhances another object without changing its interface. Decorator is thus more transparent to the application than an adapter is. As a consequence, Decorator supports recursive composition, which isn't possible with pure Adapters.
Facade defines a new interface, whereas Adapter reuses an old interface. Remember that Adapter makes two existing interfaces work together as opposed to defining an entirely new one.
 */

public class AdapterImplementationFor120VoltsSockets implements AdapterInterface {

    private SocketFor120Volts socketFor120Volts;

    public AdapterImplementationFor120VoltsSockets(SocketFor120Volts socketFor120Volts) {
        this.socketFor120Volts = socketFor120Volts;
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(socketFor120Volts.getVolt(), 40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(socketFor120Volts.getVolt(), 10);
    }

    @Override
    public Volt get120Volt() {
        return socketFor120Volts.getVolt();
    }

    private Volt convertVolt(Volt volt, int i) {
        return new Volt(volt.getVolt() / i);
    }
}
