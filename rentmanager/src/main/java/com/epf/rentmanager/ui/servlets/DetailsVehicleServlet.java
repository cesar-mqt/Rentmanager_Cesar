package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/cars/details")

public class DetailsVehicleServlet extends HttpServlet {

	@Autowired
	ClientService clientservice;

	@Autowired
	VehicleService vehicleservice;

	@Autowired
	ReservationService reservationservice;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String var_id = request.getQueryString();
			String idOk = var_id.substring(3);
			int id = Integer.parseInt(idOk);

			request.setAttribute("vehiclesData", this.vehicleservice.findById(id));

			request.setAttribute("compteClients", this.clientservice.countById(id));
			request.setAttribute("compteReservations", this.reservationservice.countByVehicleId(id));

			// request.setAttribute("Reservations",
			// this.reservationservice.findResaByVehicleId(id));
			request.setAttribute("Reservations", this.reservationservice.findResaByVehicleIdWeb(id));

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/details.jsp").forward(request, response);

	}

}
