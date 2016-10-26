package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitDao {

	public void addProductDao(Produit produit);
	public void deleteProductDao(Produit produit);
	public void updateProductDao(Produit produit);
	public List<Produit> getAllProductDao();
	public List<Produit> getProductByCatDao(Categorie categorie);
	public Produit getProductByNameDao(String name);
	
	
}
