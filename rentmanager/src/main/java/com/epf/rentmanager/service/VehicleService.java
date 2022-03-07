package com.epf.rentmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.VehicleDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;

@Service
public class VehicleService {

	private VehicleDao vehicleDao;
	public static VehicleService instance;
	
	private VehicleService(VehicleDao vehicleDao){
		this.vehicleDao = vehicleDao;
		}
	
//	public static VehicleService getInstance() {
//		if (instance == null) {
//			instance = new VehicleService();
//		}
//		
//		return instance;
//	}
	
	
	public long create(Vehicle vehicle) throws ServiceException {

		try {
		return this.vehicleDao.create(vehicle);
		} catch (DaoException e) {
		e.printStackTrace();
		}
		return 0;		
	}
	
	
	public long edit(Vehicle vehicle) throws ServiceException {

		try {
		return this.vehicleDao.edit(vehicle);
		} catch (DaoException e) {
		e.printStackTrace();
		}
		return 0;		
	}
	
	public long delete(int id) throws ServiceException {

		try {
		return this.vehicleDao.delete(id);
		} catch (DaoException e) {
		e.printStackTrace();
		}
		return 0;		
	}
	
	
	
	
	

	public Vehicle findById(int id) throws ServiceException {

		try {
			return this.vehicleDao.findById(id).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Vehicle> findAll() throws ServiceException {
		try {
		return this.vehicleDao.findAll();
		} catch (DaoException e) {
		e.printStackTrace();
		}
		return null;
	}
	
	public long count() {
		try {
		return this.vehicleDao.count();
		} catch (DaoException e) {
		e.printStackTrace();
		}
		return 0;
	}
	
	public long countById(int idCount) {
		try {
		return this.vehicleDao.countById(idCount);
		} catch (DaoException e) {
		e.printStackTrace();
		}
		return 0;
	}
	
}
