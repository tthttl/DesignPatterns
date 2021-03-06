package structural.bridge;

public class PersistenceImp implements Persistence {

//    This pattern uses 2 interfaces to completely decouple the expected behaviour from the concrete implementation.
//    This implementation of the Persistence interface does not directly implement the Persistence interface, but uses an implementor composite,
//    which however has methods to implement the behaviours, DOES NOT IMPLEMENT the original Persistence interface, but the IMPLEMENTOR (bridge_interfacewithininterface) interface.
//    Thus even the abstraction has multiple implementations.
    /*
    Bridge is designed UP-FRONT to let the abstraction and the implementation vary independently.
    Adapter is retrofitted to make unrelated classes work together.

    public interface Weapon {
    void wield();
    void swing();
    void unwield();
    Enchantment getEnchantment(); ==> Interface within the interface!
    }
     */

    private PersistenceImplementor persistenceImplementor;

    public PersistenceImp(PersistenceImplementor persistenceImplementor) {
        this.persistenceImplementor = persistenceImplementor;
    }

    @Override
    public String persist(Object object) {
        return persistenceImplementor.persist(object);
    }

    @Override
    public Object findById(String id) {
        return persistenceImplementor.findById(id);
    }

    @Override
    public void delete(String id) {
        persistenceImplementor.delete(id);
    }
}
