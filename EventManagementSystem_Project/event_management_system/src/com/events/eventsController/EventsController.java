package com.events.eventsController;

import java.util.Scanner;

import com.events.eventsService.EventsService;
import com.events.pojos.Events;

public class EventsController {
	
	private EventsService eventsService;
	
	public EventsController(EventsService eventsService)
	{
		this.eventsService = eventsService;
	}
	
	public void start()
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("\n--- Event Management System ---");
			System.out.println("1. Admin's Login");
			System.out.println("2. User's Login");
			System.out.println("3. EXIT");
			System.out.println("Enter your choice...");
			int choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				adminMenu(scanner);
				break;
			case 2:
				userMenu(scanner);
				break;
			case 3:
				System.out.println("Exiting system. GoodBye!");
				scanner.close();
				return;
			default: System.out.println("Invalid choice, please try again!");
			}
			
		}
	}
	
	private void adminMenu(Scanner scanner)
	{
		while(true)
		{
			System.out.println("\n--- Welcome Admin ---");
			System.out.println("1. Add Events");
			System.out.println("2. View Events");
			System.out.println("3. Delete Events");
			System.out.println("4. Update Events");
			System.out.println("5. Logout");
			System.out.println("Enter your choice...");
			int choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Event ID: ");
				String id = scanner.next();
				System.out.println("Enter Event Name: ");
				String name = scanner.next();
				System.out.println("Enter Event Date (DD/MM/YYYY): ");
				String date = scanner.next();
				System.out.println("Enter Event Seats: ");
				int seats = scanner.nextInt();
				
				if(eventsService.addEvent(new Events(id, name, date, seats)))
				{
					System.out.println("Event added successfully!");
				}
				else
				{
					System.out.println("Failed to add event. It's full.");
				}
				break;
			case 2:
				Events[] events = eventsService.getAllEvents();
				if(events.length == 0)
					System.out.println("No events found.");
				else
				{
					for(Events event : events)
						System.out.println(event);
				}
				break;
			case 3:
				System.out.println("Enter Event ID to delete: ");
				String eventId = scanner.next();
				if(eventsService.deleteEvent(eventId))
					System.out.println("Event Deleted Successfully!");
				else
					System.out.println("Event not found.");
				break;
			case 4:
				System.out.println("Enter Event ID: ");
				String newid = scanner.next();
				System.out.println("Enter Event Name: ");
				String newname = scanner.next();
				System.out.println("Enter Event Date (DD/MM/YYYY): ");
				String newdate = scanner.next();
				System.out.println("Enter Available Seats: ");
				int newseats = scanner.nextInt();
				
				Events updatedEvent = eventsService.updateEvent(new Events(newid, newname, newdate, newseats));
				if(updatedEvent != null)
				{
					System.out.println("Event updated successfully!");
				}
				else
				{
					System.out.println("Failed to update event. Event not found.");
				}
				break;
			case 5:
				System.out.println("Logging out from Admin Menu...");
				return;
			default:
				System.out.println("Invalid choice, please try again!");
			}
			
		}
	}
	
	private void userMenu(Scanner scanner)
	{
		while(true)
		{
			System.out.println("\n--- User Menu ---");
			System.out.println("1. View Events");
			System.out.println("2. Register for Events");
			System.out.println("3. Logout");
			System.out.println("Enter your choice...");
			int choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				Events[] events = eventsService.getAllEvents();
				if(events.length == 0)
					System.out.println("No events found.");
				else
				{
					for(Events event : events)
						System.out.println(event);
				}
				break;
			case 2:
				System.out.println("Enter Event ID to register: ");
				String eventId = scanner.next();
				System.out.println(eventsService.registerForEvent(eventId));
				break;
			case 3:
				System.out.println("Logging out from User Menu...");
				return;
			default:
				System.out.println("Invalid choice, please try again!");
			}
			
		}
	}
	
//	public static void main(String[] args)
//	{
//		
//		Scanner scan = new Scanner(System.in);
//		int input = 0;
//		
//		do
//		{
//			System.out.println("Select Option 1 for Adding.");
//			System.out.println("Select Option 2 for Removing.");
//			System.out.println("Select Option 3 for Updating.");
//			System.out.println("Select Option 4 for Getting all.");
//			System.out.println("Select Option 5 for Exit.");
//			
//			input = scan.nextInt();
//		}
//		while(input != 5);
//				
//	}
}
	
	
