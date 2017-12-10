package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImp implements ChatMediator {

    List<User> users;

    public ChatMediatorImp() {
        this.users = new ArrayList<>();
    }

//    Mediator pattern is useful when the communication logic between MULTIPLE OBJECTS is COMPLEX, we can have a central point of communication that takes care of communication logic.

    @Override
    public void sendMessage(String msg) {
        users.forEach(
                user -> user.receiveMessage(msg)
        );
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
