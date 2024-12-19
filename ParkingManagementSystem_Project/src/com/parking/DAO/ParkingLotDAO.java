package com.parking.DAO;

import com.parking.pojos.Car;
import com.parking.pojos.ParkingSlot;
import com.parking.pojos.ParkingTicket;

public class ParkingLotDAO 
{
	private ParkingSlot[] slots;
	private ParkingTicket[] tickets;
	private int ticketCount;
	
	public ParkingLotDAO(ParkingSlot[] slots, ParkingTicket[] tickets) {
		super();
		this.slots = slots;
		this.tickets = tickets;
		this.ticketCount = 0;
	}
	
	
	public void displayAvailableSlots()
	{
		System.out.println("Avaialable Parking Slots:");
		
		boolean foundAvailable = false;
		
		for(ParkingSlot slot:slots)
		{
			if(slot.isAvailable())
			{
				System.out.println("Slot ID: " + slot.getSlotId());
				foundAvailable = true;
			}
		}
		
		if(!foundAvailable)
		{
		 System.out.println("No Slots Available at the moment.");	
		}
	}
	
	
	public void parkCar(String licensePlate)
	{
		Car car = new Car(licensePlate);
		ParkingSlot slot = findAvailableSlot();
		
		if(slot != null)
		{
			slot.parkCar();
			ParkingTicket ticket = new ParkingTicket(car, slot);
			tickets[ticketCount++] = ticket;
			showParkingSuccess(ticket);
		}
		else {
			showNoSlotsAvailable();
		}
	}
	
	
	public void freeSlot(String licensePlate)
	{
		ParkingTicket ticket = findTicketByLicensePlate(licensePlate);
		if(ticket != null)
		{
			ticket.setExitTime();
			ticket.getSlot().freeSlot();
			showParkingExit(ticket);
		}
		else
		{
			showCarNotFound();
		}
		
	}
	
	


	private void showCarNotFound() {
		System.out.println("Car with this license Plate was not found");
		
	}


	private void showParkingExit(ParkingTicket ticket) {
		System.out.println("Car has exited the parking lot successfullt");
		System.out.println("License Plate: " + ticket.getCar().getLicensePlate());
		System.out.println("Slot ID: " + ticket.getSlot().getSlotId());
		System.out.println("Entry Time : " + ticket.getEntryTime());
		System.out.println("Exit Time : " + ticket.getExitTime());
		System.out.println("Parking Charge : $ " + ticket.getParkingCharge());
		
		
	}


	private ParkingTicket findTicketByLicensePlate(String licensePlate) {
		for(int i = 0; i < ticketCount; i++) {
			
		  if(tickets[i].getCar().getLicensePlate().equals(licensePlate)) {
			  return tickets[i];
		  }
		}
		return null;
	}


	private void showNoSlotsAvailable() {
		System.out.println("Sorry, no available parking slots at the moment.");
		
	}


	private void showParkingSuccess(ParkingTicket ticket) {
		
		System.out.println("Car parked successfully");
		System.out.println("License Plate: " + ticket.getCar().getLicensePlate());
		System.out.println("Slot ID: " + ticket.getSlot().getSlotId());
		System.out.println("Entry Time : " + ticket.getEntryTime());
		
	}


	private ParkingSlot findAvailableSlot() {
		for(ParkingSlot slot:slots)
		{
			if(slot.isAvailable())
			{
				return slot;
			}
		}
		return null;
	}
	
	
	
	
	
	

}
