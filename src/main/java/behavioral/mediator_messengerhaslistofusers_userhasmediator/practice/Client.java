package behavioral.mediator.practice;

public class Client {

    public static void main(String[] args) {

        Messenger messenger = new MessengerImp();
        User user1 = new UserImp(messenger, "Kati");
        User user2 = new UserImp(messenger, "Peti");
        User user3 = new UserImp(messenger, "Robi");
        messenger.addUser(user1);
        messenger.addUser(user2);
        messenger.addUser(user3);

        user1.sendMessage("Hello!");
        user2.sendMessage("Mizu?");

    }

}
