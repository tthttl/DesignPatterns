package dailypractice.mediator;

public class Client {

    public static void main (String[] args){
        ChatMediator mediator = new ChatMediatorImpl();

        User bela = new UserImpl(mediator, "bela");
        User anna = new UserImpl(mediator, "anna");
        User kinga = new UserImpl(mediator, "kinga");
        User sara = new UserImpl(mediator, "sara");

        mediator.addUser(bela);
        mediator.addUser(anna);
        mediator.addUser(kinga);
        mediator.addUser(sara);

        bela.sendMessage("Hello lanyok!!");

    }



}
