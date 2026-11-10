import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Reads and writes records using Java NIO (Path, Paths, Files)
public class FileHandler {
    private final Path filePath = Paths.get("data", "records.csv");

    public void save(List<Person> people) throws IOException {
        Files.createDirectories(filePath.getParent());
        List<String> lines = new ArrayList<>();
        for (Person p : people) {
            lines.add(p.toFileLine());
        }
        Files.write(filePath, lines);
    }

    public void load(RecordManager manager) throws IOException {
        if (!Files.exists(filePath)) {
            return;                       // first run, nothing to load
        }
        for (String line : Files.readAllLines(filePath)) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[1]);
            if (parts[0].equals("STUDENT")) {
                manager.add(new Student(id, parts[2], parts[3]));
            } else if (parts[0].equals("TEACHER")) {
                manager.add(new Teacher(id, parts[2], parts[3]));
            }
        }
    }
}
