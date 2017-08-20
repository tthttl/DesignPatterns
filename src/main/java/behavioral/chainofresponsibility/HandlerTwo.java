package behavioral.chainofresponsibility;

public class HandlerTwo extends HandlerBase {

    @Override
    protected boolean tryHandle(Request request) {
        if (request.getValue()==0){
            System.out.println("Equal to zero");
            return true;
        }
        return false;
    }
}
