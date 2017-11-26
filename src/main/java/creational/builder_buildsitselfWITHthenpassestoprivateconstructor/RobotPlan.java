package creational.builder_buildsitselfWITHthenpassestoprivateconstructor;

// csak akkor van haszna a k�sz�tend� objectet interface m�g� rejteni, ha t�bb olyan objectet akarunk l�trehozni,
// amiknek hasonl�ak a r�szei, csak elt�r�ek. pl aut� - bicikli, mindkett�nek van kereke meg korm�nya.
// Egy�bk�nt el�g a v�gs� objectet felsettelni a builderben.
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
