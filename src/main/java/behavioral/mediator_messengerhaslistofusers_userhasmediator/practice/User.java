package behavioral.mediator.practice;

public interface User {

    void sendMessage(String msg);
    void receive(String msg);
    String getName();
}
