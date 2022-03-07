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

@WebServlet("/users/details")

public class DetailsUserServlet extends HttpServlet {

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

			request.setAttribute("clients", this.clientservice.findById(id));

			request.setAttribute("compteVoitures", this.vehicleservice.countById(id));
			request.setAttribute("compteReservations", this.reservationservice.countByClientId(id));
			//request.setAttribute("Reservations", this.reservationservice.findResaByClientId(id));
			request.setAttribute("Reservations", this.reservationservice.findResaByClientIdWeb(id));
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/users/details.jsp").forward(request, response);

	}

}
