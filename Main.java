import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecordManager manager = new RecordManager();
        FileHandler fileHandler = new FileHandler();
        Scanner sc = new Scanner(System.in);

        // Load old data from file
        try {
            fileHandler.load(manager);
            System.out.println("Records loaded from file.");
        } catch (IOException e) {
            System.out.println("Could not load file: " + e.getMessage());
        }

        // Start the auto-save thread
        AutoSaver saver = new AutoSaver(manager, fileHandler);
        Thread saveThread = new Thread(saver);
        saveThread.setDaemon(true);
        saveThread.start();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Student Record System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. View All");
            System.out.println("4. Search by ID");
            System.out.println("5. Delete by ID");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int sid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Name: ");
                        String sname = sc.nextLine();
                        System.out.print("Course: ");
                        String course = sc.nextLine();
                        manager.add(new Student(sid, sname, course));
                        System.out.println("Student added.");
                        break;
                    case 2:
                        System.out.print("ID: ");
                        int tid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Name: ");
                        String tname = sc.nextLine();
                        System.out.print("Subject: ");
                        String subject = sc.nextLine();
                        manager.add(new Teacher(tid, tname, subject));
                        System.out.println("Teacher added.");
                        break;
                    case 3:
                        if (manager.getAll().isEmpty()) {
                            System.out.println("No records yet.");
                        }
                        for (Person p : manager.getAll()) {
                            System.out.println(p.describe());   // polymorphism
                        }
                        break;
                    case 4:
                        System.out.print("Enter ID: ");
                        System.out.println(manager.find(Integer.parseInt(sc.nextLine().trim())));
                        break;
                    case 5:
                        System.out.print("Enter ID: ");
                        manager.remove(Integer.parseInt(sc.nextLine().trim()));
                        System.out.println("Deleted.");
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (RecordNotFoundException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Save before exiting
        saver.stop();
        try {
            fileHandler.save(manager.getAll());
            System.out.println("Data saved. Goodbye!");
        } catch (IOException e) {
            System.out.println("Could not save: " + e.getMessage());
        }
        sc.close();
    }
}
