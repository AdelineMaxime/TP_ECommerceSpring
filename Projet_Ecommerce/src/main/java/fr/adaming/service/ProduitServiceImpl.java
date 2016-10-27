package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Service
@Transactional
public class ProduitServiceImpl implements IProduitService {

	
	@Autowired
	IProduitDao produitDao;
	
	
	@Override
	public void addProductService(Produit produit) {

		produitDao.addProductDao(produit);
	}

	@Override
	public void deleteProductService(Produit produit) {

		produitDao.deleteProductDao(produit);
	}

	@Override
	public void updateProductService(Produit produit) {

		produitDao.updateProductDao(produit);
	}

	@Override
	public List<Produit> getAllProductService() {

		return produitDao.getAllProductDao();
	}

	@Override
	public List<Produit> getProductByCatService(Categorie categorie) {

		return produitDao.getProductByCatDao(categorie);
	}

	@Override
	public Produit getProductByNameService(String name) {

		return produitDao.getProductByNameDao(name);
	}

}
