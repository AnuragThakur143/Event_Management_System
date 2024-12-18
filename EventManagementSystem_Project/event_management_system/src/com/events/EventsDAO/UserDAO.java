package com.events.EventsDAO;

import com.events.pojos.User;

public interface UserDAO {
	
	boolean registerUser(User user);
	boolean loginUser(User user);
	boolean bookEvent(String username, String eventId);
	
}
