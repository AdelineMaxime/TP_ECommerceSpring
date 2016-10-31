package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitService {

	public void addProductService(Produit produit);
	public Produit getProductByNameService(String name);
	public List<Produit> getAllProductService();
	public void deleteProductService(Produit produit);
	public void updateProductService(Produit produit);
	public List<Produit> getProductByCatService(int id);
	public void selectProductService(Produit produit);
	public List<Produit> getAllSelectedProductService();
	
}
