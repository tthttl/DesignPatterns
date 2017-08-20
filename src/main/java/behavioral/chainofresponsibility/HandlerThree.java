package behavioral.chainofresponsibility;

public class HandlerThree extends HandlerBase {


    @Override
    protected boolean tryHandle(Request request) {
        if (request.getValue()<0){
            System.out.println("Less!");
            return true;
        }
        return false;
    }
}
