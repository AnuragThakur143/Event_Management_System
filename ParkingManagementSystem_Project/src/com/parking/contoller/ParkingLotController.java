package com.parking.contoller;

import java.util.Scanner;
import com.parking.DAO.ParkingLotDAO;

public class ParkingLotController
{
	ParkingLotDAO dao;
	
	public ParkingLotController(ParkingLotDAO dao)
	{
		this.dao = dao;
	}
	
	public void start()
	{
		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			System.out.println("\n--- Parking Lot Management System ---");
		    System.out.println("1. View Available Parking Slots");
		    System.out.println("2. Park a car");
		    System.out.println("3. Free a Parking Slots");
		    System.out.println("4. EXIT");
		    System.out.println(" Choose your option...");
		    
		    int option = scanner.nextInt();
		    scanner.nextLine();
		    
		    switch(option)
		    {
		    case 1:
		    	dao.displayAvailableSlots();
		    	break;
		    case 2:
		    	System.out.println("Enter license plate number.");
		    	String licensePlateEntry = scanner.nextLine();
		    	dao.parkCar(licensePlateEntry);
		    	break;
		    case 3:
		    	System.out.println("Enter license plate number.");
		    	String licensePlateExit = scanner.nextLine();
		    	dao.freeSlot(licensePlateExit);
		    	break;
		    case 4:
		    	scanner.close();
		    	System.out.println("Parking Services is closed/exited.");
		    	return;
		    default :
		    	System.out.println("Invalid input, try again!");
		    }
		}
		
		
	}

}
