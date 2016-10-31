package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Service("produitServiceBean")
@Transactional
public class ProduitServiceImpl implements IProduitService {

	
	@Autowired
	private IProduitDao produitDao;
	
	
	@Override
	public void addProductService(Produit produit) {

		produitDao.addProductDao(produit);
		
	}


	@Override
	public Produit getProductByNameService(String name) {

		return produitDao.getProductByNameDao(name);
	}


	@Override
	public List<Produit> getAllProductService() {

		return produitDao.getAllProductDao();
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
	public List<Produit> getProductByCatService(int id) {

		return produitDao.getProductByCatDao(id);
	}


	@Override
	public void selectProductService(Produit produit) {

		produitDao.selectProductDao(produit);
	}


	@Override
	public List<Produit> getAllSelectedProductService() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
