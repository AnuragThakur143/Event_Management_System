package in.moviebooking.Service;

import in.moviebooking.DAO.BookingDAO;
import in.moviebooking.DAO.BookingDAOImpl;
import in.moviebooking.POJO.Booking;
import in.moviebooking.POJO.Movie;
import in.moviebooking.POJO.User;

public class BookingServiceImpl implements BookingService {

    BookingDAO bookingDAO = new BookingDAOImpl();

    @Override
    public void bookTicket(User user, Movie movie, int seatNumber) {
        bookingDAO.bookTicket(user, movie, seatNumber);
    }

    @Override
    public Booking[] getAllBookings() {
        return bookingDAO.getAllBookings();
    }
    

}
