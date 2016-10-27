package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="gestionnaires")
public class Gestionnaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**Déclaration de la clé primaire pour la table gestionnaires
	 * Incrémentation de 1 pour chaque nouveau gestionnaire créé
	 * Alias donné dans la base de donnée id_g
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_g")
	private int id_gestionnaire;
	
	@OneToMany(mappedBy="gestionnaire")
	private List<Role> roles;
	
	
	
	/**
	 * Définition des variables d'identification
	 */
	@Column(name="username")
	private String login;
	
	@Column(name="password")
	private String mdp;
	
	private boolean actived;
	
	/**
	 * Constructeur Vide
	 */
	
	public Gestionnaire() {
		super();
	}

	/**Constructeur avec paramètres mais sans Id
	 * @param login
	 * @param mdp
	 */
	public Gestionnaire(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	/**Constructeur avec tous les paramètres
	 * @param id_gestionnaire
	 * @param login
	 * @param mdp
	 */
	public Gestionnaire(int id_gestionnaire, String login, String mdp) {
		super();
		this.id_gestionnaire = id_gestionnaire;
		this.login = login;
		this.mdp = mdp;
	}

	/**
	 * @return the id_gestionnaire
	 */
	public int getId_gestionnaire() {
		return id_gestionnaire;
	}

	/**
	 * @param id_gestionnaire the id_gestionnaire to set
	 */
	public void setId_gestionnaire(int id_gestionnaire) {
		this.id_gestionnaire = id_gestionnaire;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gestionnaire [id_gestionnaire=" + id_gestionnaire + ", login=" + login + ", mdp=" + mdp + "]";
	}
	
	
	
	
	
	

}