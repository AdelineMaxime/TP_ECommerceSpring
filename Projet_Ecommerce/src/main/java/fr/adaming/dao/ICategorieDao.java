package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {
	
	/**
	 * Définition des méthodes
	 * 
	 */
	
	public void addCategorieDao(Categorie categorie);
	public void deleteCategorieDao(Categorie categorie);
	public void updateCategorieDao(Categorie categorie);
	public List<Categorie> getAllCategorieDao();
	public Categorie getCategorieByNameDao(String name);
	
}
