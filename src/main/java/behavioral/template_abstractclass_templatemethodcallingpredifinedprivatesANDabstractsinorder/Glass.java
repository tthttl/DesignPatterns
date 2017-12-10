package behavioral.template_abstractclass_withprivatemethodsANDtemplatemethodcallingabstractsinorder;

public class Glass extends HouseTemplate {

//    here a parent method calls methods from the child object

    @Override
    protected void buildWindows() {
        System.out.println("Glass windows are in.");
    }

    @Override
    protected void buildRoof() {
        System.out.println("Chrystal roof is in place.");
    }
}
