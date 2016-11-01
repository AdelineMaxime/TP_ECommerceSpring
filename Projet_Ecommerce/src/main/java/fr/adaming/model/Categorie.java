package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Categorie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id_categorie;
		
		private String nom;
		
		@OneToMany(mappedBy="categorie", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
		private List<Produit> listeProduit;
//-------------------------------------------------------------------------------------------------------------
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
		/**
		 * 
		 */
		public Categorie() {
			super();
		}
		/**
		 * @param nom
		 * @param listeProduit
		 */
		public Categorie(String nom) {
			super();
			this.nom = nom;
		}
		/**
		 * @param id_categorie
		 * @param nom
		 * @param listeProduit
		 */
		public Categorie(int id_categorie, String nom) {
			super();
			this.id_categorie = id_categorie;
			this.nom = nom;
		}	
//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
		/**
		 * @return the id_categorie
		 */
		public int getId_categorie() {
			return id_categorie;
		}
		/**
		 * @param id_categorie the id_categorie to set
		 */
		public void setId_categorie(int id_categorie) {
			this.id_categorie = id_categorie;
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
		 * @return the listeProduit
		 */
		public List<Produit> getListeProduit() {
			return listeProduit;
		}
		/**
		 * @param listeProduit the listeProduit to set
		 */
		public void setListeProduit(List<Produit> listeProduit) {
			this.listeProduit = listeProduit;
		}
//-------------------------------------------------------------------------------------------------------------
//------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Categorie [id_categorie=" + id_categorie + ", nom=" + nom + "]";
		}
//-------------------------------------------------------------------------------------------------------------
}