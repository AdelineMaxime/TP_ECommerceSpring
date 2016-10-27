package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	// Attributs ---------------------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="rolename")
	private String rolename;
	
	
	@ManyToOne
	@JoinColumn(name="gest_id", referencedColumnName="id_g")
	private Gestionnaire gestionnaire;

	
	// Constructeurs ------------------------------------------------
	/**
	 * 
	 */
	public Role() {
		super();
	}


	/**
	 * @param rolename
	 */
	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}


	/**
	 * @param id
	 * @param rolename
	 */
	public Role(int id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}


	
	// Getters & Setters --------------------------------------------
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}


	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	/**
	 * @return the gestionnaire
	 */
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}


	/**
	 * @param gestionnaire the gestionnaire to set
	 */
	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
	
}
