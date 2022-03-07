
package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/rents/edit")

public class EditReservationServlet extends HttpServlet {

	@Autowired
	ReservationService reservationservice;

	@Autowired
	ClientService clientservice;

	@Autowired
	VehicleService vehicleservice;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("choixClients", this.clientservice.findAll());

			request.setAttribute("choixVehicle", this.vehicleservice.findAll());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/rents/edit.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String var_id = request.getQueryString();
		String idOk = var_id.substring(3);
		int id = Integer.parseInt(idOk);

		String nomCar = request.getParameter("car");
		String nomClient = request.getParameter("client");

		String splitNomCar = nomCar.replaceAll("[^\\d]", " ").replaceAll(" +", " ").replaceFirst(".$", "");
		String splitNomClient = nomClient.replaceAll("[^\\d]", " ").replaceAll(" +", " ").replaceFirst(".$", "");

		int addIdCar = Integer.parseInt(splitNomCar);
		int addIdClient = Integer.parseInt(splitNomClient);

		String dateDebut = request.getParameter("begin");
		String dateFin = request.getParameter("end");
		LocalDate editDateDebut = LocalDate.parse(dateDebut);
		LocalDate editDateFin = LocalDate.parse(dateFin);

		Reservation editReservation = new Reservation(id, addIdClient, addIdCar, editDateDebut, editDateFin);
		
		try {
			request.setAttribute("editRservation", this.reservationservice.edit(editReservation));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.doGet(request, response);

	}

}
