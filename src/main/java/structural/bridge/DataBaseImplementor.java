package structural.bridge;

public class DataBaseImplementor implements PersistenceImplementor {


    @Override
    public String persist(Object object) {
        return null;
    }

    @Override
    public Object findById(String Id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
