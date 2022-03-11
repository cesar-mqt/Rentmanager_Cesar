package com.epf.rentmanager.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

public class Main {

	public static void main(String[] args) {

//		try {
		// System.out.println(ClientService.getInstance().findById(1));
		// System.out.println(VehicleService.getInstance().findById(1));

//			System.out.println("Rentrer le nom");
//			Scanner scan = new Scanner(System.in);
//			String addNom = scan.nextLine();
//			System.out.println(addNom);
//
//			System.out.println("Rentrer le prénom");
//			String addPrenom = scan.nextLine();
//			System.out.println(addPrenom);
//
//			System.out.println("Rentrer le mail");
//			String addEmail = scan.nextLine();
//			
//			System.out.println("Rentrer ID");
//			String strAddId = scan.nextLine();
//			int addId = Integer.valueOf(strAddId);
//			
//			
//			System.out.println("Rentrer la date de naissance: format YYYY-MM-DD");
//			String straddBirthdate = scan.nextLine();
//			LocalDate addBirthdate = LocalDate.parse(straddBirthdate);
//			
//			Client addClient = new Client(addId, addNom,addPrenom, addBirthdate,addEmail);
//			
//			System.out.println(ClientService.getInstance().create(addClient));

//			System.out.println(ClientService.getInstance().findAll());
//			System.out.println(VehicleService.getInstance().findAll());

//			System.out.println("Rentrer id a supp");
//			Scanner scan = new Scanner(System.in);
//			String scanRow = scan.nextLine();
//			int delRow = Integer.parseInt(scanRow);
//			System.out.println(delRow);
//			
//			System.out.println(ClientService.getInstance().delete(delRow));

//			System.out.println(ClientService.getInstance().count());

//			System.out.println("Rentrer le constructeur");
//			Scanner scan = new Scanner(System.in);
//			String addConstructeur = scan.nextLine();
//			System.out.println(addConstructeur);
//
//			System.out.println("Rentrer le nombre de place");
//			String straddPlaces = scan.nextLine();
//			int addPlaces = Integer.valueOf(straddPlaces);
//			
//			
//			System.out.println("Rentrer ID");
//			String strAddId = scan.nextLine();
//			int addId = Integer.valueOf(strAddId);
//			
//			Vehicle addVehicle = new Vehicle(addId, addConstructeur,addPlaces);
//			
//			System.out.println(VehicleService.getInstance().create(addVehicle));
//			
//			

//			
//			System.out.println(VehicleService.getInstance().count());
//			
//			
//			System.out.println("Rentrer id a supp");
//			Scanner scan = new Scanner(System.in);
//
//			String scanRow = scan.nextLine();
//			int delRow = Integer.parseInt(scanRow);
//			System.out.println(delRow);
//			
//			System.out.println(VehicleService.getInstance().delete(delRow));
//			System.out.println(VehicleService.getInstance().findById(1));
//
//   		System.out.println(VehicleService.getInstance().findAll());

//			
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//
	}

}
