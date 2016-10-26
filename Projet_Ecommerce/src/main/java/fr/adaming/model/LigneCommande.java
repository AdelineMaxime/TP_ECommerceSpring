package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class LigneCommande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
		@Id
		@GeneratedValue
		private long id_LC;
		
		private int quantite;
		private Double prix;
		
		@OneToOne
		@JoinColumn(name="produit_id",referencedColumnName="id_produit")
		private Produit produit;
		
		@ManyToOne
		@JoinColumn(name="panier_id", referencedColumnName="id_panier")
		private Panier panier;
//-------------------------------------------------------------------------------------------------------------
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
		/**
		 * 
		 */
		public LigneCommande() {
			super();
		}
		/**
		 * @param quantite
		 * @param prix
		 */
		public LigneCommande(int quantite, Double prix) {
			super();
			this.quantite = quantite;
			this.prix = prix;
		}
//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
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
		 * @return the produit
		 */
		public Produit getProduit() {
			return produit;
		}
		/**
		 * @param produit the produit to set
		 */
		public void setProduit(Produit produit) {
			this.produit = produit;
		}
		/**
		 * @return the panier
		 */
		public Panier getPanier() {
			return panier;
		}
		/**
		 * @param panier the panier to set
		 */
		public void setPanier(Panier panier) {
			this.panier = panier;
		}
		
		public long getId_LC() {
			return id_LC;
		}
		public void setId_LC(long id_LC) {
			this.id_LC = id_LC;
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
			return "LigneCommande [quantite=" + quantite + ", prix=" + prix + "]";
		}
//-------------------------------------------------------------------------------------------------------------
}