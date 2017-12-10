package behavioral.template_abstractclass_withprivatemethodsANDtemplatemethodcallingabstractsinorder;

public class Wooden extends HouseTemplate {


//    here a parent method calls methods from the child object
    @Override
    protected void buildWindows() {
        System.out.println("Ugly wooden windows");
    }

    @Override
    protected void buildRoof() {
        System.out.println("Sturdy wooden roof. Don't burn it down pls.");
    }
}
