package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/gestion")
public class GestionController {

	/**
	 * Autowiring permettant les m�thodes contenues dans les interfaces
	 * ICategorieService et IProduitService
	 */

	@Autowired
	ICategorieService categorieService;

	@Autowired
	IProduitService produitService;

	/**
	 * Initialisation de la page index du Gestionnaire
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listObjets(ModelMap model) {

		// R�cup�ration des cat�gories

		List<Categorie> liste = categorieService.getAllCategorieService();

		model.addAttribute("title", "Accueil gestionnaire");
		model.addAttribute("listCategorie", liste);

		// Nom de la vue renvoy�e
		return "indexGest";

	}

	/**
	 * Ajout d'une cat�gorie
	 * 
	 * @return
	 */

	@RequestMapping(value = "/addCat", method = RequestMethod.GET)
	public ModelAndView ajouterCategorie() {

		String viewName = "addCat";

		return new ModelAndView(viewName, "categorie", new Categorie());

	}

	/**
	 * Ajout d'un produit
	 * 
	 * @return
	 */

	@RequestMapping(value = "/addProd", method = RequestMethod.GET)
	public ModelAndView ajouterProduit() {

		String viewName = "addProd";

		return new ModelAndView(viewName, "produit", new Produit());

	}

	/**
	 * Cr�ation d'une nouvelle cat�gorie
	 * 
	 * @param categorie
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/insererCategorie", method = RequestMethod.POST)
	public String insererCategorie(@ModelAttribute("categorie") Categorie categorie, ModelMap model) {

		this.categorieService.addCategorieService(categorie);

		model.addAttribute("listCategorie", categorieService.getAllCategorieService());

		model.addAttribute("title", "Accueil gestionnaire");

		return "indexGest";

	}

	
	
	/**
	 * Suppression d'une cat�gorie via son nom
	 * @param catName
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/supprimerCat/{categorieName}", method = RequestMethod.GET)
	public String supprimerCategorie(@PathVariable("categorieName") String catName, ModelMap model) {

		Categorie cat = this.categorieService.getCategorieByNameService(catName);

		this.categorieService.deleteCategorieService(cat);

		model.addAttribute("listCategorie", categorieService.getAllCategorieService());
		model.addAttribute("title", "Accueil gestionnaire");

		return "indexGest";

	}
	/**
	 * Cr�ation d'un nouveau Produit
	 * 
	 * @param produit
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/insererProduit", method = RequestMethod.POST)
	public String insererProduit(@ModelAttribute("produit") Produit produit, ModelMap model) {
			
		if(produit.getId_produit() == 0){
			
			this.produitService.addProductService(produit);
			
		}else{
			
			this.produitService.updateProductService(produit);
		}
			
		
		model.addAttribute("listCategorie", categorieService.getAllCategorieService());
		model.addAttribute("title", "Accueil gestionnaire");

		return "indexGest";

	}
	
	/**
	 * R�cup�ration de la liste des produits li�es � sa cat�gorie
	 * @param idCat
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/listeProd/{id_cat}", method = RequestMethod.GET)

	public String getProduitsByIdCategorie(@PathVariable("id_cat") int idCat, ModelMap model) {

		List<Produit> liste = produitService.getProductByCatService(idCat);

		model.addAttribute("listeProdCat", liste);

		model.addAttribute("IdCat", liste.get(0).getCategorie().getId_categorie());

		model.addAttribute("nomCat", liste.get(0).getCategorie().getNom());

		return "listeProduits";
	}
	
	/**
	 * Suppression d'un produit via son nom
	 * @param prodName
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/supprimerProd/{produitName}", method = RequestMethod.GET)
	public String supprimerProduit(@PathVariable("produitName") String prodName, ModelMap model) {

		Produit prod = this.produitService.getProductByNameService(prodName);

		this.produitService.deleteProductService(prod);

		List<Produit> liste = produitService.getAllProductService();

		model.addAttribute("listProduit", liste);
		model.addAttribute("title", "Accueil gestionnaire");

		return "listeProduits";

	}
	
	/**
	 * Modification des attributs d'un produit
	 * @param name
	 * @return
	 */

	@RequestMapping(value = "/editProduit/{name}", method = RequestMethod.GET)
	public String editerProduit(@PathVariable("name") String name, ModelMap model) {

		Produit p = this.produitService.getProductByNameService(name);
		
		model.addAttribute("produit", p);
		//model.addAttribute("produitDescr", p.getDescription());
		//model.addAttribute("produitQte", p.getQuantite());
		//model.addAttribute("produitPrix", p.getPrix());
		//model.addAttribute("produitCat", p.getCategorie().getId_categorie());

		return "addProd";

	}
	
	

}
