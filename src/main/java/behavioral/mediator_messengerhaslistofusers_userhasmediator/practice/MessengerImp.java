package behavioral.mediator.practice;

import java.util.ArrayList;
import java.util.List;

public class MessengerImp implements Messenger {

    List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String msg, User sender) {
        System.out.println(sender.getName() + " wrote: " + msg);
        users.stream()
        .filter(user -> !user.equals(sender))
        .forEach(user -> user.receive(msg));
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
