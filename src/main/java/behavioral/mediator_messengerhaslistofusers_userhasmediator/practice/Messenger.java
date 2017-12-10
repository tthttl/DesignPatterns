package behavioral.mediator.practice;

public interface Messenger {

    void sendMessage(String msg, User sender);
    void addUser(User user);

}
