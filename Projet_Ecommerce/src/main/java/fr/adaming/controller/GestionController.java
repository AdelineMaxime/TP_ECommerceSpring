package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/gestion")
public class GestionController {
	
	@Autowired
	ICategorieService categorieService;

	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String init(ModelMap model) {
		
		model.addAttribute("title", "Accueil gestionnaire");
		
		return "indexGest";
	}
	
	@RequestMapping(value="/listeCategorie", method=RequestMethod.GET)
	public String listCategorie(ModelMap model){
		
		List<Categorie> liste = categorieService.getAllCategorieService();
		model.addAttribute("listCategorie", liste);
		
		return "indexGest";
		
	}
	
	
	
	
	
}
