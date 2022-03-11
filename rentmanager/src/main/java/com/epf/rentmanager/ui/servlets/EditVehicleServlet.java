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
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/cars/edit")

public class EditVehicleServlet extends HttpServlet {

	@Autowired
	VehicleService vehicleservice;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String var_id = request.getQueryString();
		String idOk = var_id.substring(3);
		int id = Integer.parseInt(idOk);

		try {
			request.setAttribute("dataVehicle", this.vehicleservice.findById(id));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/edit.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String var_id = request.getQueryString();
		String idOk = var_id.substring(3);
		int id = Integer.parseInt(idOk);

		String constructeur = request.getParameter("manufacturer");

		String nbPlace = request.getParameter("seats");
		int addNbPlace = Integer.parseInt(nbPlace);

		Vehicle editVehicle = new Vehicle(id, constructeur, addNbPlace);

		try {
			request.setAttribute("editVehicle", this.vehicleservice.edit(editVehicle));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.doGet(request, response);

	}

}
