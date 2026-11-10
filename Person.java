// Base class (Inheritance) - Student and Teacher extend this
public abstract class Person implements Describable {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    // Each child class must provide its own role
    public abstract String getRole();

    // Used when saving to file: type,id,name,extra
    public abstract String toFileLine();

    @Override
    public String describe() {
        return getRole() + " | ID: " + id + " | Name: " + name;
    }

    @Override
    public String toString() {
        return describe();
    }
}
