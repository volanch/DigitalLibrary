public class LibraryUser {
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

    public String getValues() {
        return this.name + " (" + this.id + ")";
    }
}