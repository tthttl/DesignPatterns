package creational.builder;

public class RobotBuilder implements Builder {

    private RobotPlan robotPlan;

    //itt lehet megmondani a Builderben, hogy konkrétan milyen Robotot is szeretnénk, bármit lehet ami implementálja a RobotPlant
    public RobotBuilder() {
        this.robotPlan = new Robot();
    }

    // Ez tulképp semmi mást nem csinál, csak meghívja a beállítandó object settereit és beállítja õket, egy elõre beégetett konfignak megfelelõen.
    //Azaz nem lehet runtime megadni. Ha módosítnai szeretnénk akkor másik buildert kell létrehozni. Ha lenne a build methodoknak paraméterük, akkor olyanok lennének, mint a
    //driverek az integrációs teszteknél, akkor menet közben lehetne beadni az értéket. withHead("head").. De mivel itt van egy director class is, ahol meghívja ezeket a build methodokat,
    // így a user semmit sem lát abból, hogy mikor vagy hogyan történik az értékek beállítása.
    @Override
    public void buildRobotHead() {
        robotPlan.setHead("kukafej");
    }

    @Override
    public void buildRobotTorso() {
        robotPlan.setTorso("DunaTorzó");
    }

    @Override
    public void buildRobotArms() {
        robotPlan.setArms("flamethrower");
    }

    @Override
    public void buildRobotLegs() {
        robotPlan.setLegs("kétballáb");
    }

    @Override
    public RobotPlan getRobot() {
        return robotPlan;
    }
}
