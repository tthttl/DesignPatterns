package structural.proxy_impelementsthesameprotocolANDwrapstheoriginalANDcallsitwhenneededORallowed;

// Proxy also implements the interface and has a field with the interface type ==> its own showImage method calls the proxifiedImage's interface method.
public class ImageProxy implements ImageInterface {

    private ImageInterface proxifiedImage;

    @Override
    public void showImage() {
        proxifiedImage = new HighResImage();
        proxifiedImage.showImage();
    }
}
