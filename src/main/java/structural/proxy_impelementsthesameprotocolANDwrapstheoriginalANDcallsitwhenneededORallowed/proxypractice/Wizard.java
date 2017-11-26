package structural.proxy_impelementsthesameprotocolANDwrapstheoriginalANDcallsitwhenneededORallowed.proxypractice;

public class Wizard {

    private String name;

    public Wizard(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
