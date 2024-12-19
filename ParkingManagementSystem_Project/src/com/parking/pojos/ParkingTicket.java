package com.parking.pojos;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket 
{
	private Car car;
	private ParkingSlot slot;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private double parkingCharge;
	
	public ParkingTicket(Car car, ParkingSlot slot) {
		super();
		this.car = car;
		this.slot = slot;
		this.entryTime = car.getEntryTime();
		this.exitTime = null;
		this.parkingCharge = 0.0;
	}
	
	public void calculateParkingCharge()
	{
		if(exitTime != null)
		{
		Duration duration =	Duration.between(exitTime, entryTime);
	    // say a rate of $2 per hour
		
		 parkingCharge = duration.toHours()*5;
		 
		 if(duration.toMinutes() % 60  > 0)
		 {
			 parkingCharge += 3; // additional charge for the minutes
		 }
	
		}
	}
	
	public void setExitTime()
	{
		this.exitTime = LocalDateTime.now();
		calculateParkingCharge();
	}
	
	public double getParkingCharge()
	{
		return parkingCharge;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public ParkingSlot getSlot() {
		return slot;
	}

	public void setSlot(ParkingSlot slot) {
		this.slot = slot;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}

	public void setParkingCharge(double parkingCharge) {
		this.parkingCharge = parkingCharge;
	}
	
	
	
	
	
	
	

}
