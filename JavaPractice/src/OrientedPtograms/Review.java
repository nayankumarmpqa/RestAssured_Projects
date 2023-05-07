package OrientedPtograms;

public class Review {
    private int id;
    private String reviewDescription;
    private int rating;
    public Review(int id, String reviewDescription, int rating) {

        this.id=id;
        this.reviewDescription=reviewDescription;
        this.rating=rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewDescription='" + reviewDescription + '\'' +
                ", rating=" + rating +
                '}';
    }
}
