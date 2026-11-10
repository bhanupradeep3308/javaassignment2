import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Stores all records using Collections (HashMap + ArrayList)
public class RecordManager {
    private final Map<Integer, Person> records = new HashMap<>();

    // synchronized -> safe when the auto-save thread reads at the same time
    public synchronized void add(Person p) {
        if (records.containsKey(p.getId())) {
            throw new IllegalArgumentException("ID " + p.getId() + " already exists!");
        }
        records.put(p.getId(), p);
    }

    public synchronized Person find(int id) throws RecordNotFoundException {
        Person p = records.get(id);
        if (p == null) {
            throw new RecordNotFoundException("No record found with ID " + id);
        }
        return p;
    }

    public synchronized void remove(int id) throws RecordNotFoundException {
        if (records.remove(id) == null) {
            throw new RecordNotFoundException("No record found with ID " + id);
        }
    }

    public synchronized List<Person> getAll() {
        return new ArrayList<>(records.values());
    }
}
