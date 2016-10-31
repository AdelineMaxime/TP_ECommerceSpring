package fr.adaming.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping(value="/client")
public class ClientController {

	
	@Autowired
	private IProduitService produitService;
	
	@Autowired
	private ICategorieService categorieService;
	
	@Autowired
	private IClientService clientService;
	
	// Map regroupant toutes les lignes de commandes du client
	Map<Integer, LigneCommande> Articles = new HashMap<Integer, LigneCommande>();
	
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String initClient(ModelMap model) {
		
		List<Produit> listeProd = produitService.getAllProductService();
		
		// En ouvrant le site, aucun produit n'est selectionné
		for (Produit p:listeProd) {
			p.setSelection(false);
		}
		
		List<Categorie> listeCat = categorieService.getAllCategorieService();
		model.addAttribute("title", "Accueil client");
		model.addAttribute("produitList", listeProd);
		model.addAttribute("categorieList", listeCat);		
		
		return "indexClient";
	}
	
	
	@RequestMapping(value = "/listeProd/{id_cat}", method = RequestMethod.GET)
	public String getProduitsByIdCategorie(@PathVariable("id_cat") int idCat, ModelMap model) {
		List<Produit> liste = produitService.getProductByCatService(idCat);
		model.addAttribute("listeProdCat", liste);
		
		return "listeProduitParCat";
	}

	@RequestMapping(value = "/addPanier/{nom_prod}", method = RequestMethod.GET)
	public String addPanier(@PathVariable("nom_prod") String nomProd, ModelMap model) {
		
		Produit p1 = produitService.getProductByNameService(nomProd);
		
		// Si le produit n'a pas encore été ajouté au panier
		if (p1.isSelection()==false) {
			
			// Créer une nouvelle ligne de commande correspondante
			LigneCommande lc = new LigneCommande();
			lc.setProduit(p1);
			lc.setQuantite(1);
			lc.setPrix(p1.getPrix());
			
			// Ajouter la ligne de commande à la map avec l'id du produit comme clé
			Articles.put(p1.getId_produit(), lc);
			
			// Modifier le booléen Selection de produit en True une fois le produit ajouté au panier
			produitService.selectProductService(p1);
			
		} else {
			// Si le produit a déjà été ajouté au panier
			// Rechercher la ligne de commande correspondante
			LigneCommande lc = Articles.get(p1.getId_produit());
			
			// Incrémenter la quantité
			lc.setQuantite(lc.getQuantite()+1);
			
			// Ajuster le prix
			lc.setPrix(p1.getPrix()*lc.getQuantite());
			
		}
			
		// Recharger la liste des catégories et des produits
		List<Produit> prodList = produitService.getAllProductService();
		List<Categorie> catListe = categorieService.getAllCategorieService();
		model.addAttribute("prouitList", prodList);
		model.addAttribute("categorieList", catListe);
		
		return "indexClient";
	}
	
	
	@RequestMapping(value="/panier", method = RequestMethod.GET)
	public String voirPanier(ModelMap model) {
		
		List<LigneCommande> lcList = new ArrayList<LigneCommande>();
			
		// Créer la liste de ligne de commande
		for (LigneCommande lc:Articles.values()) {
			lcList.add(lc);
		}
			
		// Déterminer le cout total du panier
		Panier panier = new Panier();
		panier.setPrixTotal(0.00);
		
		for (LigneCommande lc:lcList) {
			panier.setPrixTotal(panier.getPrixTotal()+lc.getPrix());
		}
		
		model.addAttribute("panierList", lcList);
		model.addAttribute("prix", panier.getPrixTotal());
				
		return "panier";
	}
	
	
	
}
