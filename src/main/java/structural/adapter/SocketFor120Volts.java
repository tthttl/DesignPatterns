package structural.adapter;

public class SocketFor120Volts {

    public Volt getVolt(){
        return new Volt(120);
    }

}
