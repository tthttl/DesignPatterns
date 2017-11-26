package creational.builder_buildsitselfWITHthenpassestoprivateconstructor;

// csak akkor van haszna a készítendõ objectet interface mögé rejteni, ha több olyan objectet akarunk létrehozni,
// amiknek hasonlóak a részei, csak eltérõek. pl autó - bicikli, mindkettõnek van kereke meg kormánya.
// Egyébként elég a végsõ objectet felsettelni a builderben.
public interface RobotPlan {

    void setHead(String head);

    String getHead();

    void setTorso(String torso);

    String getTorso();

    void setArms(String arms);

    String getArms();

    void setLegs(String legs);

    String getLegs();
}
