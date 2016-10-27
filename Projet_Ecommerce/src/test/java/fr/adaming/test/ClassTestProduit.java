package fr.adaming.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

public class ClassTestProduit {

	public static void main(String[] args) {

		ApplicationContext cxt = new FileSystemXmlApplicationContext("C:\\Users\\inti0288\\git\\TP_ECommerceSpring\\Projet_Ecommerce\\src\\main\\webapp\\WEB-INF\\application-context.xml");
		
		IProduitService produitService = (IProduitService) cxt.getBean("produitServiceBean");
		
		Produit p1 = new Produit("a", "a", 1.00, 1, false);
		
		//produitService.addProductService(p1);
		
		//System.out.println(p1);
	
		//System.out.println(produitService.getProductByNameService("a"));
		//Produit p2=produitService.getProductByNameService("a");
		//produitService.deleteProductService(p2);
		
//		Produit p2 = new Produit(2, "b", "b", 1.00, 1, false);
//		
//		produitService.updateProductService(p2);
		
		List<Produit> liste = produitService.getAllProductService();
		
		System.out.println(liste);
		
		
	}

}
