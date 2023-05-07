package OrientedPtograms;

import java.util.ArrayList;

public class Book {

    private int bookId;
    private String bookName;
    private String author;

    private ArrayList<Review> reviews = new ArrayList<Review>();
    public Book(int bookId, String bookName, String author) {
        this.bookId=bookId;
        this.bookName=bookName;
        this.author=author;
    }

    public void addReview(Review review) {

        this.reviews.add(review);
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
