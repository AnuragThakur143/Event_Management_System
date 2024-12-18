package com.events.eventsService;

import com.events.EventsDAO.EventsDAO;
import com.events.eventExceptions.EventsFullException;
import com.events.eventExceptions.InvalidEventException;
import com.events.eventExceptions.EventNotFoundException;
import com.events.pojos.Events;

public class EventsServiceImpl implements EventsService {
	
	private EventsDAO eventsDAO;
	
	public EventsServiceImpl(EventsDAO eventsDAO)
	{
		this.eventsDAO = eventsDAO;
	}

	@Override
	public boolean addEvent(Events event) {
		boolean res = eventsDAO.addEvent(event);
		
		if(res == false)
		{
			throw new EventsFullException("No more events accepted.");
		}
		return res;
	}

	@Override
	public Events[] getAllEvents() {
		Events[] events = eventsDAO.getAllEvents();
		
        if (events == null || events.length == 0)
        {
            throw new EventNotFoundException("No events available.");
        }
		return events;
	}

	@Override
	public boolean deleteEvent(String eventId) {
		if (eventId == null || eventId.isEmpty())
		{
            throw new InvalidEventException("Event ID cannot be null or empty.");
        }
		
        boolean result = eventsDAO.deleteEvent(eventId);

        if (!result)
        {
            throw new EventNotFoundException("Event with ID: " + eventId + " not found.");
        }
		return result;
	}

	@Override
	public Events getEventById(String eventId) {
		if (eventId == null || eventId.isEmpty())
		{
            throw new InvalidEventException("Event ID cannot be null or empty.");
        }
		
        Events event = eventsDAO.getEventById(eventId);

        if (event == null)
        {
            throw new EventNotFoundException("Event with ID: " + eventId + " not found.");
        }
		return event;
	}

	@Override
	public Events updateEvent(Events newEvent) {
		if (newEvent == null || newEvent.getEventId() == null || newEvent.getEventId().isEmpty())
		{
            throw new InvalidEventException("Event or Event ID cannot be null/empty for update.");
        }
		
        Events updatedEvent = eventsDAO.updateEvent(newEvent);

        if (updatedEvent == null)
        {
            throw new EventNotFoundException("Unable to update. Event not found with ID: " + newEvent.getEventId());
        }
		return updatedEvent;
	}

	@Override
	public String registerForEvent(String eventId) {
		
		Events event = eventsDAO.getEventById(eventId);
		
		if(event == null)
		{
			return "No Event Found.";
		}
		if(event.getAvailableSeats() <= 0)
		{
			return "No seats available.";
		}
		event.setAvailableSeats(event.getAvailableSeats() - 1);
		return "Successfully Registered!";
	}

}
