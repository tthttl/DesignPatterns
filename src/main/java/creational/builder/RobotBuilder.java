package creational.builder;

public class RobotBuilder implements Builder {

    private RobotPlan robotPlan;

    //itt lehet megmondani a Builderben, hogy konkr�tan milyen Robotot is szeretn�nk, b�rmit lehet ami implement�lja a RobotPlant
    public RobotBuilder() {
        this.robotPlan = new Robot();
    }

    // Ez tulk�pp semmi m�st nem csin�l, csak megh�vja a be�ll�tand� object settereit �s be�ll�tja �ket, egy el�re be�getett konfignak megfelel�en.
    //Azaz nem lehet runtime megadni. Ha m�dos�tnai szeretn�nk akkor m�sik buildert kell l�trehozni. Ha lenne a build methodoknak param�ter�k, akkor olyanok lenn�nek, mint a
    //driverek az integr�ci�s tesztekn�l, akkor menet k�zben lehetne beadni az �rt�ket. withHead("head").. De mivel itt van egy director class is, ahol megh�vja ezeket a build methodokat,
    // �gy a user semmit sem l�t abb�l, hogy mikor vagy hogyan t�rt�nik az �rt�kek be�ll�t�sa.
    @Override
    public void buildRobotHead() {
        robotPlan.setHead("kukafej");
    }

    @Override
    public void buildRobotTorso() {
        robotPlan.setTorso("DunaTorz�");
    }

    @Override
    public void buildRobotArms() {
        robotPlan.setArms("flamethrower");
    }

    @Override
    public void buildRobotLegs() {
        robotPlan.setLegs("k�tball�b");
    }

    @Override
    public RobotPlan getRobot() {
        return robotPlan;
    }
}
