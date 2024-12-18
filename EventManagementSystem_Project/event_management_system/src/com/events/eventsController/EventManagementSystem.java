package com.events.eventsController;

import com.events.eventsService.EventsService;
import com.events.eventsService.EventsServiceImpl;
import com.events.EventsDAO.EventsDAO;
import com.events.EventsDAO.EventsDAOImpl;

public class EventManagementSystem {
	
	public static void main(String[] args) {
		
		EventsDAO dao = new EventsDAOImpl(10);
		EventsService service = new EventsServiceImpl(dao);
		EventsController controller = new EventsController(service);
		
		controller.start();
		
	}
}
