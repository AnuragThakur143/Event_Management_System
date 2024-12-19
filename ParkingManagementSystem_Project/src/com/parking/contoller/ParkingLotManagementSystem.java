package com.parking.contoller;

import com.parking.DAO.ParkingLotDAO;
import com.parking.pojos.ParkingSlot;
import com.parking.pojos.ParkingTicket;

public class ParkingLotManagementSystem 
{
	public static void main(String[] args) 
	{
		ParkingSlot[] slots = new ParkingSlot[5];
		for(int i = 0; i < slots.length; i++)
		{
			slots[i] = new ParkingSlot(i+1);	
		}


		ParkingTicket[] tickets = new ParkingTicket[5];
		
		ParkingLotDAO dao = new ParkingLotDAO(slots,tickets);
		ParkingLotController controller = new ParkingLotController(dao);
		controller.start();

	}

}
