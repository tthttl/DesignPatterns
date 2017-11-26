package structural.proxy_impelementsthesameprotocolANDwrapstheoriginalANDcallsitwhenneededORallowed.proxypractice;

public class WizardTowerProxy implements WizardTower {

    private static final int MAX_WIZARDS = 3;
    private static int wizardsEntered = 0;

    private WizardTower wizardTower;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }

    @Override
    public void enter(Wizard wizard) {
        if(wizardsEntered >= MAX_WIZARDS){
            System.out.println(wizard.getName() + " have to wait!");
            return;
        }
        wizardTower.enter(wizard);
        wizardsEntered++;
    }
}
