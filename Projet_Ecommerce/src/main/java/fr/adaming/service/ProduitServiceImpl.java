package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

@Service("produitServiceBean")
@Transactional
public class ProduitServiceImpl implements IProduitService {

	
	@Autowired
	private IProduitDao produitDao;
	
	/**
	 * Ajouter un produit
	 */
	@Override
	public void addProductService(Produit produit) {

		produitDao.addProductDao(produit);
		
	}


	/**
	 * Obtenir un prduit à l'aide de son nom
	 */
	@Override
	public Produit getProductByNameService(String name) {

		return produitDao.getProductByNameDao(name);
	}


	/**
	 * Obtenir tous les produits
	 */
	@Override
	public List<Produit> getAllProductService() {

		return produitDao.getAllProductDao();
	}


	/**
	 * Supprimer un produit
	 */
	@Override
	public void deleteProductService(Produit produit) {
	
		produitDao.deleteProductDao(produit);
	}


	/**
	 * Modifier un produit
	 */
	@Override
	public void updateProductService(Produit produit) {

		produitDao.updateProductDao(produit);
	}


	/**
	 * Obtenir tous les produits d'une catégorie
	 */
	@Override
	public List<Produit> getProductByCatService(int id) {

		return produitDao.getProductByCatDao(id);
	}
	

}
