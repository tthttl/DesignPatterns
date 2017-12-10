package behavioral.mediator.practice;

public class UserImp implements User {

    private Messenger messenger;
    private String name;

    public UserImp(Messenger messenger, String name) {
        this.messenger = messenger;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void sendMessage(String msg) {
        messenger.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(name + " received: " + msg);
    }
}
