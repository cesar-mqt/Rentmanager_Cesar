package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Client {

	private String Nom;
	private String Prenom;
	private String email;
	private LocalDate BirthDate;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public LocalDate getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		BirthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client(int id, String nom, String prenom, String email, LocalDate birthDate) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.email = email;
		BirthDate = birthDate;
		this.id = id;
	}

	public String toString() {
		return Nom.toString() + "," + Prenom.toString() + "," + email.toString() + "," + BirthDate.toString();
	}

}
