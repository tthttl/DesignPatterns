package behavioral.chainofresponsibility_handlerbasewithchainofsuccessorsandabstracttryhandle.chainpractice;

import behavioral.chainofresponsibility_handlerbasewithchainofsuccessorsandabstracttryhandle.Request;

public class Client {

    public static void main(String[] args) {

        Handler2 handler2 = new Handler2(null);
        Handler1 handler1 = new Handler1(handler2);

        handler1.handleRequest(new Request(10,"whatever"));

    }

}
