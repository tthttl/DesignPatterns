package behavioral.chainofresponsibility_handlerbasewithchainofsuccessorsandabstracttryhandle;

public class Client {

//    Linked List of Handlers ==> It is only determined at runtime which handler can handle the request.
//    handleRequest => tryHandle => if failed call successor(next handler)
    public static void main (String[] args){

        HandlerBase h1 = new HandlerOne();
        HandlerBase h2 = new HandlerTwo();
        HandlerBase h3 = new HandlerThree();

        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        Request request = new Request(-1, "minus one");

        h1.handleRequest(request);

    }

}
