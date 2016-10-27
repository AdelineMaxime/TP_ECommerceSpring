package fr.adaming.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

public class ClassTestCategorie {
	
	public static void main(String[] args) {
		
		ApplicationContext cxt= new FileSystemXmlApplicationContext("C:\\Users\\inti0301\\git\\TP_ECommerceSpring\\ecom\\Projet_Ecommerce\\src\\main\\webapp\\WEB-INF\\application-context.xml");
		
		ICategorieService categorieService= (ICategorieService) cxt.getBean("categorieServiceBean");
		
		Categorie c1= new Categorie("Sport");
		
//		categorieService.addCategorieService(c1);
//		
//		System.out.println(c1);
		
//		c1.setNom("Voiture");
//		
//		categorieService.updateCategorieService(c1);
		
		//Categorie c2= categorieService.getCategorieByNameService("Sport");
		
		//categorieService.deleteCategorieService(c2);
		
//		Categorie c3 = new Categorie(3, "Video");
//		
//		categorieService.updateCategorieService(c3);
		
		List<Categorie> liste = categorieService.getAllCategorieService();
		
		System.out.println(liste);
		
		
		
		
	}

}
