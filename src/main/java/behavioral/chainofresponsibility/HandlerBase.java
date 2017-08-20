package behavioral.chainofresponsibility;

public abstract class HandlerBase {

    protected HandlerBase successor;

    public void setSuccessor(HandlerBase successor) {
        this.successor = successor;
    }

    protected abstract boolean tryHandle(Request request);

    protected final void handleRequest (Request request){

        boolean isHandled = this.tryHandle(request);

        if(this.successor != null && !isHandled){
            this.successor.handleRequest(request);
        }

        if (this.successor == null && !isHandled){
            System.out.println("No suitable Handler");
        }
    }

}
