package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

public class CategorieServiceImpl implements ICategorieService {
	
	@Autowired
	ICategorieDao categorieDao;
	
	@Override
	public void addCategorieService(Categorie categorie) {
		
		
		categorieDao.addCategorieDao(categorie);

	}

	@Override
	public void deleteCategorieService(Categorie categorie) {

		categorieDao.deleteCategorieDao(categorie);

	}

	@Override
	public void updateCategorieService(Categorie categorie) {

		categorieDao.updateCategorieDao(categorie);

	}

	@Override
	public List<Categorie> getAllCategorieService() {

		return categorieDao.getAllCategorieDao();
	}

}
