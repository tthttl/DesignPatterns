package behavioral.chainofresponsibility_handlerbasewithchainofsuccessorsandabstracttryhandle.chainpractice;

import behavioral.chainofresponsibility_handlerbasewithchainofsuccessorsandabstracttryhandle.Request;

import java.util.Random;

public class Handler1 extends HandlerBase {

    Random random = new Random();

    public Handler1(HandlerBase successor) {
        super(successor);
    }

    @Override
    public boolean tryHandle(Request request) {
        System.out.println("Trying to handle request!");
        return random.nextBoolean();
    }
}
