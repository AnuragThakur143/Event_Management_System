package com.events.EventsDAO;

import com.events.pojos.Events;

public class EventsDAOImpl implements EventsDAO {
	
	private Events[] events;
	private int eventCount;
	
	public EventsDAOImpl(int capacity)
	{
		this.events = new Events[capacity];
		this.eventCount = 0;
	}
	
	@Override
	public boolean addEvent(Events event) {
		
		if(events.length == 0)
		{
			events[eventCount++] = event;
		}
		
		else if(eventCount > events.length) {
			return false; //array is full...
		}
		else
		{
			events[eventCount++] = event;
		}
		return true;
	}

	@Override
	public Events[] getAllEvents() {
		Events[] availableEvents = new Events[eventCount];
		System.arraycopy(events, 0, availableEvents, 0, eventCount);
		if(events.length <= 0)
			return null;
		else
			return availableEvents;
	}

	@Override
	public boolean deleteEvent(String eventId) {
		for(int i = 0; i < eventCount; i++)
		{
			if(events[i].getEventId().equals(eventId))
			{
				for(int j = i; j < eventCount-1; j++)
				{
					events[j] = events[j+1]; //shifting elements in array after deleting...
				}
				events[--eventCount] = null;  //cleaning the last element in array...
				return true;
			}
		}
		return false;
	}

	@Override
	public Events getEventById(String eventId) {
		
		Events res = null;
		
		for(int i = 0; i < eventCount; i++)
		{
			if(events[i].getEventId().equals(eventId))
			{
				res = events[i];
			}
		}
		return res;
		
	}

	@Override
	public Events updateEvent(Events newEvent) {

		Events res = null;
		
		for(int i = 0; i < eventCount; i++)
		{
			if(events[i].getEventId().equals(newEvent.getEventId()))
			{
				events[i] = newEvent;
				return newEvent;
			}
		}
		return null;
	}

}
