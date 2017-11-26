package structural.proxy_impelementsthesameprotocolANDwrapstheoriginalANDcallsitwhenneededORallowed;

public class HighResImage implements ImageInterface{


    private Object loadActualImage(){
        return new Object();
    }

    @Override
    public void showImage() {
        loadActualImage();
    }
}
