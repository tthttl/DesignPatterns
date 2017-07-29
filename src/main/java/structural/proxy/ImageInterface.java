package structural.proxy;

public interface ImageInterface {
// Both the Proxy and the HighRes implements this. In the proxy it creates a new HighRes and calls its show image method.
// Both Highres and Proxy are wrapper classes. ==> HighRes wraps the final object, Proxy wraps the HighRes
// Creating a proxy is cheap and it can substitute the actual object, since both implement the same interface. The actual object is only created when the common interface's show method is called.
// It can also serve as a security check, the final object can only be loaded, after the proxy validated the user.
    void showImage();

}
