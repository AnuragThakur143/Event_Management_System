package in.moviebooking.DAO;

import in.moviebooking.POJO.Booking;
import in.moviebooking.POJO.Movie;
import in.moviebooking.POJO.User;

public class BookingDAOImpl implements BookingDAO {

    Booking[] booking = new Booking[10];
    int bookingCount = 0;

    int[] totalSeats = null;

    public BookingDAOImpl(int size) {
        totalSeats = new int[size];
        for (int i = 0; i < booking.length; i++) {
            totalSeats[i] = i+1;
        }
    }

    public BookingDAOImpl() {
        //TODO Auto-generated constructor stub
    }

    public int checkSeats() {
        return totalSeats.length;
    }

    public void seatBooked(int seatNum) {
        for (int i = 0; i < booking.length; i++) {
            if (totalSeats[i] == seatNum)
            totalSeats[i] = -1;
        }
    }

    public boolean isSeatAvailable(int seatNum) {
        for (int i = 0; i < booking.length; i++) {
            if (totalSeats[i] == seatNum)
            return true;
        }
        return false;
    }

    @Override
    public void bookTicket(User user, Movie movie, int seatNumber) {
        if (bookingCount < booking.length)
        {
            booking[bookingCount++] = new Booking(user, movie, seatNumber);
        }
    }

    @Override
    public Booking[] getAllBookings() {
        return booking;
    }
    
}
