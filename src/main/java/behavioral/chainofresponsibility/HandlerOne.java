package behavioral.chainofresponsibility;

public class HandlerOne extends HandlerBase {

    @Override
    protected boolean tryHandle(Request request) {
        if(request.getValue()>0){
            System.out.println("Greater");
            return true;
        }
        return false;
    }
}
