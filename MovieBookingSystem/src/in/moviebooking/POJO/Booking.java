package in.moviebooking.POJO;

public class Booking {
    private User user;
    private Movie movie;
    private int seatNumber;

    public Booking(User user, Movie movie, int seatNumber) {
        this.user = user;
        this.movie = movie;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Booking [user=" + user + ", movie=" + movie + ", seatNumber=" + seatNumber + "]";
    }

    
}
