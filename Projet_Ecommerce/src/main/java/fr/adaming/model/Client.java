
package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Client implements Serializable{
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
		private long id_client;
		
		private String nom;
		private String adresse;
		private String mail;
		private String password;
		private int tel;
		
		@OneToMany(mappedBy="client")
		private List<Commande> listeCommandes;
		
		@OneToOne(mappedBy="clientP")
		private Panier panier;
		
		@PostConstruct
		public void init(){
			this.panier=new Panier();
		}
//-------------------------------------------------------------------------------------------------------------		
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
		/**
		 * 
		 */
		public Client() {
			super();
		}
		/**
		 * @param nom
		 * @param adresse
		 * @param mail
		 * @param password
		 * @param tel
		 * @param panier
		 */
		public Client(String nom, String adresse, String mail, String password, int tel) {
			super();
			this.nom = nom;
			this.adresse = adresse;
			this.mail = mail;
			this.password = password;
			this.tel = tel;
			//this.panier = new Panier();
		}
		/**
		 * @param id_client
		 * @param nom
		 * @param adresse
		 * @param mail
		 * @param password
		 * @param tel
		 * @param panier
		 */
		public Client(long id_client, String nom, String adresse, String mail, String password, int tel) {
			super();
			this.id_client = id_client;
			this.nom = nom;
			this.adresse = adresse;
			this.mail = mail;
			this.password = password;
			this.tel = tel;
			this.panier = new Panier();
		}
//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
		/**
		 * @return the id_client
		 */
		public long getId_client() {
			return id_client;
		}
		/**
		 * @param id_client the id_client to set
		 */
		public void setId_client(Long id_client) {
			this.id_client = id_client;
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
		 * @return the adresse
		 */
		public String getAdresse() {
			return adresse;
		}
		/**
		 * @param adresse the adresse to set
		 */
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		/**
		 * @return the mail
		 */
		public String getMail() {
			return mail;
		}
		/**
		 * @param mail the mail to set
		 */
		public void setMail(String mail) {
			this.mail = mail;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the tel
		 */
		public int getTel() {
			return tel;
		}
		/**
		 * @param tel the tel to set
		 */
		public void setTel(int tel) {
			this.tel = tel;
		}
		/**
		 * @return the listeCommandes
		 */
		public List<Commande> getListeCommandes() {
			return listeCommandes;
		}
		/**
		 * @param listeCommandes the listeCommandes to set
		 */
		public void setListeCommandes(List<Commande> listeCommandes) {
			this.listeCommandes = listeCommandes;
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
			return "Client [id_client=" + id_client + ", nom=" + nom + ", adresse=" + adresse + ", mail=" + mail
					+ ", password=" + password + ", tel=" + tel + "]";
		}
//-------------------------------------------------------------------------------------------------------------
}