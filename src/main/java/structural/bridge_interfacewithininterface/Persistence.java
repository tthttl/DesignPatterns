package structural.bridge;

public interface Persistence {

    String persist(Object object);
    Object findById(String id);
    void delete(String id);

}
