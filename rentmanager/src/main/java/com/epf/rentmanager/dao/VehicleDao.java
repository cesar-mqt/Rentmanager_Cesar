package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository

public class VehicleDao {

//	private static VehicleDao instance = null;
//	private VehicleDao() {}
//	public static VehicleDao getInstance() {
//		if(instance == null) {
//			instance = new VehicleDao();
//		}
//		return instance;
//	}
//	
	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, nb_places) VALUES(?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";
	private static final String COUNT_VEHICLE_QUERY = "SELECT COUNT (id) FROM Vehicle;";

	private static final String COUNT_VEHICLE_BY_ID_QUERY = "SELECT COUNT (*) FROM Reservation WHERE client_id=?;";
	private static final String UPDATE_VEHICLE_QUERY = "UPDATE Vehicle SET constructeur=?, nb_places=? WHERE id=?;";

	public long count() throws DaoException {

		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(COUNT_VEHICLE_QUERY);

			ResultSet rs = pstmt.executeQuery();

			rs.next();
			int compte = rs.getInt(1);

			return compte;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public long countById(int idCount) throws DaoException {

		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(COUNT_VEHICLE_BY_ID_QUERY);

			pstmt.setInt(1, idCount);

			ResultSet rs = pstmt.executeQuery();

			rs.next();
			int compte = rs.getInt(1);

			return compte;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public long edit(Vehicle vehicle) throws DaoException {

		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_VEHICLE_QUERY);

			pstmt.setString(1, vehicle.getConstructeur());
			pstmt.setInt(2, vehicle.getNbPlace());
			pstmt.setInt(3, vehicle.getId());

			pstmt.executeUpdate();

			return 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public long create(Vehicle vehicle) throws DaoException {

		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_VEHICLE_QUERY);

			// Client addclient = new Client(addNom, addPrenom, addEmail, straddBirthdate);

			pstmt.setString(1, vehicle.getConstructeur());
			pstmt.setInt(2, vehicle.getNbPlace());

			pstmt.executeUpdate();

			return 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public long delete(int id) throws DaoException {

		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_VEHICLE_QUERY);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			System.out.println("Ligne supprimée");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public Optional<Vehicle> findById(int id) throws DaoException {

		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLE_QUERY);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			int vehicleId = rs.getInt("id");
			String constructeur = rs.getString("constructeur");
			// String modele = rs.getString("modele");
			int nbPlaces = rs.getInt("nb_places");

			Vehicle vehicle = new Vehicle(vehicleId, constructeur, nbPlaces);

			return Optional.of(vehicle);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public List<Vehicle> findAll() throws DaoException {
		try {

			List<Vehicle> vehicles = new ArrayList<Vehicle>();

			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLES_QUERY);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String constructeur = rs.getString("constructeur");
				int nb_places = rs.getInt("nb_places");

				Vehicle vehicle = new Vehicle(id, constructeur, nb_places);

				vehicles.add(vehicle);
			}

			return vehicles;
			// System.out.println(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();

		}
	}

}
