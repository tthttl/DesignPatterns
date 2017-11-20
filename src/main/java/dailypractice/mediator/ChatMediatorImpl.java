package dailypractice.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

    List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, String name) {
        users.stream()
                .filter(user -> !user.name.equals(name))
                .forEach(filteredUser -> filteredUser.receiveMessage(message));
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
