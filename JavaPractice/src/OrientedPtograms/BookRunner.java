package OrientedPtograms;

public class BookRunner {
    public static void main(String[] args) {
        Book book = new Book(123, "book1", "writer1");

        System.out.println(book);

        book.addReview(new Review(10, "Great", 5));
        book.addReview(new Review(11, "Great", 4));


        System.out.println(book);

    }
}
