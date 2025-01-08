public class LibraryUser extends LibraryEntity {
    private String name;
    private int id;

    public LibraryUser(String name, int id) {
        this.name = name;
        this.id = id;
        setValues(name, id);
    }

    public void setValues(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getDetails() {
        return name + " (ID: " + id + ")";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + id;
    }
}