package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Produit implements Serializable{
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
		private int id_produit;
		
		private String nom;
		private String description;
		private Double prix;
		private int quantite;
		private boolean selection;
		
		@ManyToOne
		@JoinColumn(name="categorie_id", referencedColumnName="id_categorie")
		private Categorie categorie;
		
		@OneToOne(mappedBy="produit")
		private LigneCommande ligneC;
//-------------------------------------------------------------------------------------------------------------
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
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
		public Produit(String nom, String description, Double prix, int quantite, boolean selection) {
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
		public Produit(int id_produit, String nom, String description, Double prix, int quantite, boolean selection) {
			super();
			this.id_produit = id_produit;
			this.nom = nom;
			this.description = description;
			this.prix = prix;
			this.quantite = quantite;
			this.selection = selection;
		}
	//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */

		public int getId_produit() {
			return id_produit;
		}
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
		public Double getPrix() {
			return prix;
		}
		/**
		 * @param prix the prix to set
		 */
		public void setPrix(Double prix) {
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
			return "Produit [id_produit=" + id_produit + ", nom=" + nom + ", description=" + description + ", prix="
					+ prix + ", quantite=" + quantite + ", selection=" + selection + "]";
		}
//-------------------------------------------------------------------------------------------------------------
	
}