package behavioral.mediator;

public class UserImp extends User {

    public UserImp(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("Message Sent: " + msg);
        chatMediator.sendMessage(msg);
    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println("Message received: " + msg);
    }
}
