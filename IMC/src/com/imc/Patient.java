package com.imc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="patient")
public class Patient implements Serializable {
	private String nom;
	private int age;
	private String sexe;
	private float poids;
	private float taille;
	private String nationalite;
	private String traitement;
	private List<String> listeTraitement;
	
	public Patient() {
		listeTraitement = new ArrayList<String>();
		listeTraitement.add("Régime à base d'aliments gras");
		listeTraitement.add("Nouveau calcul de l'IMC dans 6 mois");
		listeTraitement.add("Régime léger");
		listeTraitement.add("Régime sévère");
		listeTraitement.add("Régime très sévère");
	}
	public List<String> getListeTraitement() {
		return listeTraitement;
	}
	public void setListeTraitement(List<String> listeTraitement) {
		this.listeTraitement = listeTraitement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}
	
	public float calculImc() {
		return (float) ((float) poids / Math.pow(taille, 2));
	}
	
	public String afficherResultat(float imc) {
		String res = "";
		if(imc <= 18.5)
			res = "Poids insuffisant";
		else if(imc > 18.5 && imc <= 25)
			res = "Corpulence normale";
		else if(imc > 25 && imc <= 30)
			res = "Surpoids";
		else if(imc > 30 && imc <= 35)
			res = "Obésité modérée";
		else if(imc > 35 && imc <= 40)
			res = "Obésité sévère";
		else
			res = "Obésité morbide ou massive";
		return res;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getTraitement() {
		return traitement;
	}
	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}

}
