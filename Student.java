// Student inherits from Person and overrides its methods
public class Student extends Person {
    private String course;

    public Student(int id, String name, String course) {
        super(id, name);
        this.course = course;
    }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public String describe() {                 // Method overriding
        return super.describe() + " | Course: " + course;
    }

    @Override
    public String toFileLine() {
        return "STUDENT," + id + "," + name + "," + course;
    }
}
