package structural.bridge;


import java.util.HashMap;
import java.util.Random;

public class FileSystemImplementor implements PersistenceImplementor{

    HashMap<String, Object> fileSystem = new HashMap<>();
    Random random = new Random();

    @Override
    public String persist(Object object) {
        String key = String.valueOf(random.nextInt());
        fileSystem.put(key, object);
        return key;
    }

    @Override
    public Object findById(String Id) {
        return fileSystem.get(Id);
    }

    @Override
    public void delete(String id) {
        fileSystem.remove(id);
    }
}