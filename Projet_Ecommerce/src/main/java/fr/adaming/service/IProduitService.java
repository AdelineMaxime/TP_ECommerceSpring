package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitService {

	public void addProductService(Produit produit);
	public void deleteProductService(Produit produit);
	public void updateProductService(Produit produit);
	public List<Produit> getAllProductService();
	public List<Produit> getProductByCatService(Categorie categorie);
	public Produit getProductByNameService(String name);
	
}
