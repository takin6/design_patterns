package Iterator;

// Iteratorパターン：何かがたくさん集まっているときに、それを順番に指し示していき、全体をスキャンしていく処理
// Actor: Iterator, ConcreteIterator, Aggregate, ConcreteAggregate
// Pros: whileループは、BookShelfの実装に依存しなくなる
// Note
    // - 抽象クラス・インターフェースは、結合を弱め、クラスを部品として再利用しやすくする

public class Main {
    public static void main(String[] args) {
//        BookShelf bookShelf = new BookShelf(4);
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Snow White"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
