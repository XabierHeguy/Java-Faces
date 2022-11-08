package com.school.user;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;



@ManagedBean

public class user implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String mdp;
	private boolean marie;
	private String sexe;
	
	public boolean isMarie() {
		return marie;
	}

	public void setMarie(boolean marie) {
		this.marie = marie;
	}

	public String getMdp() {
		System.out.println("appel du getMdp() pour le mdp : " + mdp);
		return mdp;
	}

	public void setMdp(String mdp) {
		System.out.println("appel du setMdp() pour le mdp : " + mdp);
		this.mdp = mdp;
	}

	public user() {
		System.out.println("Construction");
	}
	
	public String getNom() {
		System.out.println("appel du getNom() pour le nom : " + nom);
		return nom;
	}
	public void setNom(String nom) {
		System.out.println("appel du setNom() pour le nom : " + nom);
		this.nom = nom;
	}
	
	public String getPrenom() {
		System.out.println("appel du getPrenom() pour le nom : " + prenom);
		return prenom;
	}
	public void setPrenom(String prenom) {
		System.out.println("appel du setPrenom() pour le nom : " + prenom);
		this.prenom = prenom;
	}
	
	@Override
	protected void finalize() {
	    System.out.println("destruction de la classe");
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public void monToString() {
		String retour = "";
		if (marie==true)
			retour = "[ " + nom + ", " + prenom + ", " + mdp + ", marié, " + sexe + " ]";
		else
			retour = "[ " + nom + ", " + prenom + ", " + mdp + ", non marié, " + sexe + " ]";
		System.out.println(retour);
	}

}
