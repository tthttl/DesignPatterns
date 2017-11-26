package structural.adapter_wrapsandconvertstheoldobject;

public class Client {

    public static void main(String[] args) {

        SocketFor120Volts socketFor120Volts = new SocketFor120Volts();
        //az adapter wrappeli a régi objectet és úgy convertálja ahogy szükséges
        AdapterInterface adapter = new AdapterImplementationFor120VoltsSockets(socketFor120Volts);
        Volt volt12 = adapter.get12Volt();
        System.out.println(volt12);

    }



}
