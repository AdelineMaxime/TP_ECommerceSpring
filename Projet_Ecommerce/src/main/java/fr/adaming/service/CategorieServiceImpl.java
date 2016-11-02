package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Service("categorieServiceBean")
@Transactional
public class CategorieServiceImpl implements ICategorieService {
	
	@Autowired
	ICategorieDao categorieDao;
	
	/**
	 * Redéfinition de la méthode d'ajout d'une catégorie
	 */
	
	@Override
	public void addCategorieService(Categorie categorie) {
		
		categorieDao.addCategorieDao(categorie);
		
	}
	
	/**
	 * Redéfinition de la méthode de suppression d'une catégorie
	 */

	@Override
	public void deleteCategorieService(Categorie categorie) {

		categorieDao.deleteCategorieDao(categorie);

	}
	
	/**
	 *Redéfinition de la méthode de modification d'une catégorie 
	 */

	@Override
	public void updateCategorieService(Categorie categorie) {

		categorieDao.updateCategorieDao(categorie);

	}
	
	/**
	 * Redéfinition de la méthode de récupération des catégories
	 */

	@Override
	public List<Categorie> getAllCategorieService() {

		return categorieDao.getAllCategorieDao();
	}
	
	/**
	 * Redéfinition de la méthode de récupération d'une catégorie via son nom
	 */

	@Override
	public Categorie getCategorieByNameService(String name) {
		
		return categorieDao.getCategorieByNameDao(name);
	}

}
