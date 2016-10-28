package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping(value="/client")
public class ClientController {

	
	@Autowired
	private IProduitService produitService;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String initClient(ModelMap model) {
		
		List<Produit> liste = produitService.getAllProductService();
		model.addAttribute("title", "Accueil client");
		model.addAttribute("produitList", liste);
		
		return "indexClient";
	}
	
	
	@RequestMapping(value="/panier", method=RequestMethod.GET)
	public String displayPanier(ModelMap model) {
		
		List<Produit> liste = produitService.getAllSelectedProduct();
		model.addAttribute("lignesComm", liste);
		
		return "panier";
	}
	
}
