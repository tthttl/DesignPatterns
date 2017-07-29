package structural.bridge;

public interface Persistence {

    String perist(Object object);
    Object findById(String id);
    void delete(long id);

}
