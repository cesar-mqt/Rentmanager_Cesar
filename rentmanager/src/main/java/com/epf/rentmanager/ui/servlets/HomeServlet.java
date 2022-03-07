package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/home")

public class HomeServlet extends HttpServlet {

	@Autowired
	ClientService clientService;

	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	ReservationService reservationService;
	
	 @Override
	 public void init() throws ServletException {
	 super.init();
	 SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("countVehicles", this.vehicleService.count());
		request.setAttribute("countClients", this.clientService.count());
		request.setAttribute("countResas", this.reservationService.count());

		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp") ;
//		requestDispatcher.forward(request, response) ;
		getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);

		
		
		
	}

}
