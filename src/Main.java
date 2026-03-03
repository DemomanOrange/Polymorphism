import java.util.ArrayList;

// Base class
class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void getFormat() {
        System.out.println("Generic book format");
    }
}

// Subclasses
class EBook extends Book {
    public EBook(String title, String author) { super(title, author); }

    @Override
    public void getFormat() {
        System.out.println("Digital format");
    }
}

class PrintedBook extends Book {
    public PrintedBook(String title, String author) { super(title, author); }

    @Override
    public void getFormat() {
        System.out.println("Paper format");
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();

        library.add(new EBook("Digital Fortress", "Dan Brown"));
        library.add(new PrintedBook("The Hobbit", "J.R.R. Tolkien"));

        for (Book b : library) {
            System.out.print(b.title + " by " + b.author + " - Format: ");
            b.getFormat(); // Polymorphism in action
        }
    }
}