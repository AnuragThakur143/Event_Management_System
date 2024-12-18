package com.events.EventsDAO;

import com.events.pojos.Events;

public interface EventsDAO {
	
	boolean addEvent(Events event);
	Events[] getAllEvents();
	boolean deleteEvent(String eventId);
	Events getEventById(String eventId);
	Events updateEvent(Events newEvent);
}
