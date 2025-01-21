package Entity;

public class Book extends LibraryEntity {
    private int id;
    private String title;
    private String author;
    private int year;


    public Book(int id, String title, String author, int year) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public Book(String title, String author, int year) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getDetails() {
        return "\"" + title + "\" written in " + year + " by " + author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book comparedbook)){
            return false;
        }
        return this.year == comparedbook.year;
    }

    @Override
    public int hashCode() {
        return title.hashCode() + author.hashCode() + year;
    }
}