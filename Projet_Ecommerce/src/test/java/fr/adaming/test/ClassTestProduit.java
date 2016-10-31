package fr.adaming.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.ILigneCommService;
import fr.adaming.service.IProduitService;

public class ClassTestProduit {

	public static void main(String[] args) {

		ApplicationContext cxt = new FileSystemXmlApplicationContext("C:\\Users\\inti0288\\git\\TP_ECommerceSpring\\ecom\\Projet_Ecommerce\\src\\main\\webapp\\WEB-INF\\application-context.xml");

		IProduitService produitService = (IProduitService) cxt.getBean("produitServiceBean");
		
//		Produit p1 = new Produit("a", "a", 1, 1, false);
//		
//		produitService.addProductService(p1);
//		
//		System.out.println(p1);
		
//		Produit p2 = produitService.getProductByNameService("a");
//		System.out.println(p2);
//		
//		produitService.deleteProductService(p2);
		
//		System.out.println(produitService.getAllProductService());
		
//		Produit p3 = new Produit(2, "b", "b", 1, 1, false);
//		
//		produitService.updateProductService(p3);
		
		List<Produit> liste1 = produitService.getProductByCatService(1);
		System.out.println(liste1);
		System.out.println("-----------------------------");
		
		
	}
}
