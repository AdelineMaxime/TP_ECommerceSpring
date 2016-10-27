package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gestion")
public class GestionController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String init(ModelMap model) {
		
		model.addAttribute("title", "Accueil gestionnaire");
		
		return "indexGest";
	}
	
	
}
