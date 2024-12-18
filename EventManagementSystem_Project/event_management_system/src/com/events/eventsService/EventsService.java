package com.events.eventsService;

import com.events.pojos.Events;

public interface EventsService {
	
	boolean addEvent(Events event);
	Events[] getAllEvents();
	boolean deleteEvent(String eventId);
	Events getEventById(String eventId);
	Events updateEvent(Events newEvent);
	String registerForEvent(String eventId);
}
