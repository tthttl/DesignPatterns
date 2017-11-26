package structural.bridge;

public class Client {

    public static void main(String[] args) {

        PersistenceImplementor implementor = new FileSystemImplementor();
        /*Two identical interfaces ==> The implementation of the first wraps the implementation of the second AND the overridden methods return
        the result of the method of the second.
        The bridge_interfacewithininterface pattern is a design pattern used in software engineering
        that is meant to "decouple an abstraction from its implementation so that the two can vary independently"
        */

        Persistence persistence = new PersistenceImp(implementor);

        String idKuty = persistence.persist("kiskutya");
        String idMacs = persistence.persist("kismacska");

        System.out.println(persistence.findById(idKuty));
        System.out.println(persistence.findById(idMacs));

    }

}
