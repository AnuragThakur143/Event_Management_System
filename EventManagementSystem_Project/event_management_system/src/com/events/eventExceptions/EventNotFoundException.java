package com.events.eventExceptions;

public class EventNotFoundException extends RuntimeException {
	
	public EventNotFoundException(String message)
	{
		super(message);
	}

}
