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
	
	@Autowired
	ICategorieService categorieService;
	
	@Autowired
	IProduitService produitService;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listObjets(ModelMap model){
		
		List<Categorie> liste = categorieService.getAllCategorieService();
		
		List<Produit> listeP = produitService.getAllProductService();
		
		model.addAttribute("title", "Accueil gestionnaire");
		model.addAttribute("listCategorie", liste);
		
		model.addAttribute("listProduit", listeP);
		
		return "indexGest";
		
	}
	
	@RequestMapping(value="/addCat", method=RequestMethod.GET)
	public ModelAndView ajouterCategorie(){
		
		String viewName= "addCat";
		
		return new ModelAndView(viewName, "categorie", new Categorie());
		
	}
	
	
	@RequestMapping(value="/addProd", method=RequestMethod.GET)
	public ModelAndView ajouterProduit(){
		
		String viewName= "addProd";
		
		return new ModelAndView(viewName, "produit", new Produit());
		
	}
	
	
	
	@RequestMapping(value="/insererCategorie", method=RequestMethod.POST)
	public String insererCategorie(@ModelAttribute("categorie") Categorie categorie, ModelMap model){
			
		this.categorieService.addCategorieService(categorie);
		
		model.addAttribute("listCategorie", categorieService.getAllCategorieService());
		model.addAttribute("listProduit", produitService.getAllProductService());
		
		return "indexGest";
		
	}
	
	@RequestMapping(value="/insererProduit", method=RequestMethod.POST)
	public String insererProduit(@ModelAttribute("produit") Produit produit, ModelMap model){
			
		this.produitService.addProductService(produit);
		
		model.addAttribute("listProduit", produitService.getAllProductService());
		model.addAttribute("listCategorie", categorieService.getAllCategorieService());
		
		return "indexGest";
		
	}
	
	
	@RequestMapping(value="/supprimerCat/{categorieName}", method=RequestMethod.GET)
	public String supprimerCategorie(@PathVariable("categorieName") String catName, ModelMap model){
		
		Categorie cat = this.categorieService.getCategorieByNameService(catName);
		
		this.categorieService.deleteCategorieService(cat);
		
		model.addAttribute("listCategorie", categorieService.getAllCategorieService());
		
		return "indexGest";
		
	}
	

	
	
	
	
	
	
	
}
