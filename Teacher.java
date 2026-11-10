// Teacher inherits from Person and overrides its methods
public class Teacher extends Person {
    private String subject;

    public Teacher(int id, String name, String subject) {
        super(id, name);
        this.subject = subject;
    }

    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public String describe() {                 // Method overriding
        return super.describe() + " | Subject: " + subject;
    }

    @Override
    public String toFileLine() {
        return "TEACHER," + id + "," + name + "," + subject;
    }
}
