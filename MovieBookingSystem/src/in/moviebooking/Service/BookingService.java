package in.moviebooking.Service;

import in.moviebooking.POJO.Booking;
import in.moviebooking.POJO.Movie;
import in.moviebooking.POJO.User;

public interface BookingService {

    public void bookTicket(User user, Movie movie, int seatNumber);
    public Booking[] getAllBookings();
}
