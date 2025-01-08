public class Book extends LibraryEntity {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
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