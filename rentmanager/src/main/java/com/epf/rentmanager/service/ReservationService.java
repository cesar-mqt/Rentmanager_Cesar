package com.epf.rentmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.ReservationDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.ReservationWeb;

@Service
public class ReservationService {

	private ReservationDao reservationDao;
	public static ClientService instance;

	private ReservationService(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	public long create(Reservation reservation) throws ServiceException {
		try {
			return this.reservationDao.create(reservation);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public long delete(int id) throws ServiceException {

		try {
			return this.reservationDao.delete(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public long edit(Reservation reservation) throws ServiceException {

		try {
			return this.reservationDao.edit(reservation);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Reservation> findResaByClientId(int clientId) throws ServiceException {

		try {
			return this.reservationDao.findResaByClientId(clientId).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Reservation> findResaByVehicleId(int vehicleId) throws ServiceException {
		try {
			return this.reservationDao.findResaByVehicleId(vehicleId).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Reservation> findAll() throws ServiceException {
		try {
			return this.reservationDao.findAll().get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;

	}

	public long count() {
		try {
			return this.reservationDao.count();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long countByClientId(int idCount) {
		try {
			return this.reservationDao.countByClientId(idCount);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long countByVehicleId(int idCount) {
		try {
			return this.reservationDao.countByVehicleId(idCount);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<ReservationWeb> affichageWeb() throws ServiceException {

		try {

			return this.reservationDao.affichageWeb().get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<ReservationWeb> findResaByClientIdWeb(int idClient) throws ServiceException {

		try {

			return this.reservationDao.findResaByClientIdWeb(idClient).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<ReservationWeb> findResaByVehicleIdWeb(int idVehicle) throws ServiceException {

		try {

			return this.reservationDao.findResaByVehicleIdWeb(idVehicle).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;

	}

}
