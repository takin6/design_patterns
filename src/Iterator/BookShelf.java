package Iterator;

import java.util.ArrayList;

public class BookShelf implements Aggregate {
//    private Book[] books;
    private ArrayList<Book> books;
    private int last = 0;

//    public BookShelf(int maxsize) {
    public BookShelf() {
//        this.books = new Book[maxsize];
        this.books = new ArrayList<Book>();
    }

    public Book getBookAt(int index) {
//        return books[index];
        return books.get(index);
    }

    public void appendBook(Book book) {
//        this.books[last] = book;
        this.books.add(book);
        last++;
    }

    public int getlength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
