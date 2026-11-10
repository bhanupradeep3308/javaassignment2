import java.io.IOException;

// Runs in a separate thread and saves the records every 10 seconds
public class AutoSaver implements Runnable {
    private final RecordManager manager;
    private final FileHandler fileHandler;
    private volatile boolean running = true;

    public AutoSaver(RecordManager manager, FileHandler fileHandler) {
        this.manager = manager;
        this.fileHandler = fileHandler;
    }

    public void stop() { running = false; }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10000);
                fileHandler.save(manager.getAll());
                System.out.println("\n[Auto-save done]");
            } catch (InterruptedException e) {
                break;
            } catch (IOException e) {
                System.out.println("\n[Auto-save failed: " + e.getMessage() + "]");
            }
        }
    }
}
