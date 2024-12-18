package com.events.EventsDAO;

import com.events.pojos.TicketBookings;
import com.events.pojos.User;

public class UserDAOImpl implements UserDAO {
	
	private User[] users;
	private TicketBookings[] bookings;
	
	@Override
	public boolean registerUser(User user) {
		return false;
	}
	@Override
	public boolean loginUser(User user) {
		return false;
	}
	@Override
	public boolean bookEvent(String username, String eventId) {
		return false;
	}
}
