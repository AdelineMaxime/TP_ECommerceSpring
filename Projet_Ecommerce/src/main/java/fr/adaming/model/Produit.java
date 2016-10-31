package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Attributs -------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_produit;
	
	private String nom;
	private String description;
	private double prix;
	private int quantite;
	private boolean selection;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cat_id", referencedColumnName="id_categorie")
	private Categorie categorie;


	// Contsructeurs ----------------------------------------------------------------
	/**
	 * 
	 */
	public Produit() {
		super();
	}


	/**
	 * @param nom
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selection
	 */
	public Produit(String nom, String description, double prix, int quantite, boolean selection) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selection = selection;
	}


	/**
	 * @param id_produit
	 * @param nom
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selection
	 */
	public Produit(int id_produit, String nom, String description, double prix, int quantite, boolean selection) {
		super();
		this.id_produit = id_produit;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selection = selection;
	}


	// Getters & Setters -----------------------------------------------------------
	/**
	 * @return the id_produit
	 */
	public int getId_produit() {
		return id_produit;
	}


	/**
	 * @param id_produit the id_produit to set
	 */
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}


	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}


	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}


	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	/**
	 * @return the selection
	 */
	public boolean isSelection() {
		return selection;
	}


	/**
	 * @param selection the selection to set
	 */
	public void setSelection(boolean selection) {
		this.selection = selection;
	}


	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}


	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	// Méthodes --------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", nom=" + nom + ", description=" + description + ", prix=" + prix
				+ ", quantite=" + quantite + ", selection=" + selection + ", categorie=" + categorie + "]";
	}
	

}