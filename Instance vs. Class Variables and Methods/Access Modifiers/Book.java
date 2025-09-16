class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book {
    private double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void displayInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("File Size: " + fileSize + " MB");
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("978-0134685991", "Effective Java", "Joshua Bloch", 5.2);
        ebook.displayInfo();
        System.out.println("Author: " + ebook.getAuthor());
    }
}
