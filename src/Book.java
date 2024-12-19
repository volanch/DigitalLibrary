public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        setValues(title, author, year);
    }

    public void setValues(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getValues() {
        return this.title + " written in " + this.year + " by " + this.author;
    }

    public boolean equals(Book other) {
        return this.title.equals(other.title) && this.author.equals(other.author);
    }
}

