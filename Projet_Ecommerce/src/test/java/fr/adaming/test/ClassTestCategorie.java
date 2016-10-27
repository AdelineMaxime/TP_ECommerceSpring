package fr.adaming.test;

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
		
		categorieService.deleteCategorieService(c1);
		
		System.out.println(c1);
		
	}

}
