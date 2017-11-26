package behavioral.chainofresponsibility_handlerbasewithchainofsuccessorsandabstracttryhandle.chainpractice;

import behavioral.chainofresponsibility_handlerbasewithchainofsuccessorsandabstracttryhandle.Request;

public abstract class HandlerBase {

    protected HandlerBase successor;

    public HandlerBase(HandlerBase successor) {
        this.successor = successor;
    }

    protected boolean isHandled;

    public abstract boolean tryHandle(Request request);

    public void handleRequest(Request request){

        isHandled = tryHandle(request);

        if(successor != null && isHandled != true){
           successor.handleRequest(request);
        }

        if(successor == null && isHandled != true){
            throw new RuntimeException("No suitable Handler");
        }

    }

}
