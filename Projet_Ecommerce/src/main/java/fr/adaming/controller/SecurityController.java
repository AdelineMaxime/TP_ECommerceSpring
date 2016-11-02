package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {
	
	/**
	 * Methode permettant l'identification
	 * 
	 */

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	/**
	 * Méthode permettant la deconnexion
	 * 
	 */
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout() {
		return "login";
	}
	
}
