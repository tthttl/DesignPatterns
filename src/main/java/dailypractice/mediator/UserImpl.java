package dailypractice.mediator;

public class UserImpl extends User {

    public UserImpl(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    public void sendMessage(String message) {
        chatMediator.sendMessage(message, this.name);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message + "by: " + this.name);
    }
}
