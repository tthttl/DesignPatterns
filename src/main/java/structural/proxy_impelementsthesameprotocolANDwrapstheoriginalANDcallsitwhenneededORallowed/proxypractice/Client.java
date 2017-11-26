package structural.proxy_impelementsthesameprotocolANDwrapstheoriginalANDcallsitwhenneededORallowed.proxypractice;

public class Client {

    public static void main(String[] args) {

        Wizard red = new Wizard("Red Wizard");
        Wizard black = new Wizard("Black Wizard");
        Wizard white = new Wizard("White Wizard");
        Wizard pink = new Wizard("Pink Wizard");
        Wizard rose = new Wizard("Rose Wizard");

        WizardTower tower = new IvoryTower();
        WizardTower proxy = new WizardTowerProxy(tower);

        proxy.enter(red);
        proxy.enter(black);
        proxy.enter(white);
        proxy.enter(pink);
        proxy.enter(rose);

    }

}
