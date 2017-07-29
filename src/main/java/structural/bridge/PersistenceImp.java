package structural.bridge;

public class PersistenceImp implements Persistence {

//    This pattern uses 2 interfaces to completely decouple the expected behaviour from the concrete implementation.
//    This implementation of the Persistence interface does not directly implements the Persistence interface, but uses an implementor composite,
//    which however has methods to implement the behaviours, DOES NOT IMPLEMENT the original Persistence interface, but the IMPLEMENTOR (bridge) interface.
//    Thus even the abstraction has multiple implementations.

    private PersistenceImplementor persistenceImplementor;

    public PersistenceImp(PersistenceImplementor persistenceImplementor) {
        this.persistenceImplementor = persistenceImplementor;
    }

    @Override
    public String perist(Object object) {
        return persistenceImplementor.persist(object);
    }

    @Override
    public Object findById(String id) {
        return persistenceImplementor.findById(id);
    }

    @Override
    public void delete(long id) {
        persistenceImplementor.delete(id);
    }
}
