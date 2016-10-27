package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {
	
	public void addCategorieService(Categorie categorie);
	public void deleteCategorieService(Categorie categorie);
	public void updateCategorieService(Categorie categorie);
	public List<Categorie> getAllCategorieService();
	public Categorie getCategorieByIdService(int id_categorie);
	public Categorie getCategorieByNameService(String name);

}
