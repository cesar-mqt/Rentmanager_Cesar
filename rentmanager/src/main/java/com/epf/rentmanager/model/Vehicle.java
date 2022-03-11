package com.epf.rentmanager.model;

public class Vehicle {

	private String constructeur;
	private String modele;
	private int nbPlace;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public Vehicle(int id, String constructeur, int nbPlace) {
		super();
		this.constructeur = constructeur;
		// this.modele = modele;
		this.nbPlace = nbPlace;
		this.id = id;
	}

	public String toString() {
		return constructeur.toString() + "," + nbPlace;
	}

}
