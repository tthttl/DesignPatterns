package structural.bridge;

public interface PersistenceImplementor {

    String persist (Object object);
    Object findById(String Id);
    void delete(String id);

}
