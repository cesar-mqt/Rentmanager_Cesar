package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ReplaceOverride;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;

@WebServlet("/users/create")

public class CreateUserServlet extends HttpServlet {

	@Autowired
	ClientService clientservice;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		


		
		getServletContext().getRequestDispatcher("/WEB-INF/views/users/create.jsp").forward(request, response);

		
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		
		int id = 0;
		String nom = request.getParameter("last_name");
		String prenom = request.getParameter("first_name");
		String email = request.getParameter("email");
		String birthDate = request.getParameter("naissance");
		LocalDate addbirthDate = LocalDate.parse(birthDate);
		

//		String dateComparaison = birthDate.replace("-", "");
//		int dateNumNaissance = Integer.parseInt(dateComparaison);
//		
//		String dateDuJour = LocalDate.now().toString();	
//		String dateAjd = dateDuJour.replace("-", "");
//		int dateNumAjd = Integer.parseInt(dateAjd); 
//
//
//		
//		if (dateNumAjd-dateNumNaissance > 180000) {
			
			
		Client addClient = new Client(id,nom,prenom,email,addbirthDate);
		
		try {
			request.setAttribute("addClients", this.clientservice.create(addClient));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.doGet(request,response);
		}
		
//		else {
//			
//		
//
//			
//		}
	//}		
		
		


}
