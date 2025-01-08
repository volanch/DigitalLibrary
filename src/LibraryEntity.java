public abstract class LibraryEntity {

    public abstract String getDetails();

    @Override
    public String toString() {
        return getDetails();
    }

}
