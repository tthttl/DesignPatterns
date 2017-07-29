package structural.adapter;

//aim is that two separate classes could work together
//possible to use abstract class instead of interface
//current implementation is object adapter, because of composition. its possible to use inheritance instead => class adapter

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
