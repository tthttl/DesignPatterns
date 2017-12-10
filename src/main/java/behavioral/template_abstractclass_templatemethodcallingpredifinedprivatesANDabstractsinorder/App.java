package behavioral.template_abstractclass_withprivatemethodsANDtemplatemethodcallingabstractsinorder;

public class App {

    HouseTemplate template = new Glass();

    public static void main (String[] args){

        HouseTemplate template = new Glass();
        template.buildHouse();

    }

}
