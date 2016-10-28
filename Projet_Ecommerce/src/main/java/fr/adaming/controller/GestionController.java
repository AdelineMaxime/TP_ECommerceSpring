package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/gestion")
public class GestionController {
	
	@Autowired
	ICategorieService categorieService;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listCategorie(ModelMap model){
		
		List<Categorie> liste = categorieService.getAllCategorieService();
		model.addAttribute("title", "Accueil gestionnaire");
		model.addAttribute("listCategorie", liste);
		
		return "indexGest";
		
	}
	
	@RequestMapping(value="/addCat", method=RequestMethod.GET)
	public ModelAndView ajouterCategorie(){
		
		String viewName= "addCat";
		
		return new ModelAndView(viewName, "categorie", new Categorie());
		
	}
	
	@RequestMapping(value="/insererCategorie", method=RequestMethod.POST)
	public String insererCategorie(@ModelAttribute("categorie") Categorie categorie, ModelMap model){
		
		if(categorie.getId_categorie() == 0){
			
			this.categorieService.addCategorieService(categorie);
			
		}else{
			
			this.categorieService.updateCategorieService(categorie);
		}
		
		model.addAttribute("listCategorie", categorieService.getAllCategorieService());
		
		return "indexGest";
		
	}
	
	
	
	
	
	
	
	
}
