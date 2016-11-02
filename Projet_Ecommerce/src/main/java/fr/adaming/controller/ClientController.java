package fr.adaming.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private IProduitService produitService;

	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IPanierService panierService;
	
	@Autowired
	private ICommandeService commandeService;

	// Map regroupant toutes les lignes de commandes du client
	Map<Integer, LigneCommande> Articles = new HashMap<Integer, LigneCommande>();

	Panier panierC = new Panier();

	/**
	 * Initialisation de la page index du client
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String initClient(ModelMap model) {

		List<Categorie> listeCat = categorieService.getAllCategorieService();
		model.addAttribute("title", "Accueil client");
		model.addAttribute("categorieList", listeCat);

		return "indexClient";
	}

	/**
	 * R�cup�rer la liste des produits d'une cat�gorie
	 * 
	 * @param idCat
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listeProd/{id_cat}", method = RequestMethod.GET)
	public String getProduitsByIdCategorie(@PathVariable("id_cat") int idCat, ModelMap model) {
		List<Produit> liste = produitService.getProductByCatService(idCat);
		model.addAttribute("listeProdCat", liste);
		model.addAttribute("nomCat", liste.get(0).getCategorie().getNom());

		return "listeProduitParCat";
	}

	/**
	 * Ajouter un produit au panier
	 * 
	 * @param nomProd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addPanier/{nom_prod}", method = RequestMethod.GET)
	public String addPanier(@PathVariable("nom_prod") String nomProd, ModelMap model) {

		Produit p1 = produitService.getProductByNameService(nomProd);

		// V�rifier si le produit est encore en stock
		if (p1.getQuantite() == 0) {

			model.addAttribute("message", "Le produit d�sir� n'est plus en stock");

		} else {

			// Rechercher la ligne de commande correspondant au produit
			LigneCommande lc1 = Articles.get(p1.getId_produit());

			
			if (lc1 == null) {		// Si le produit n'a pas encore �t� ajout� au panier

				// Cr�er une nouvelle ligne de commande correspondante
				LigneCommande lc = new LigneCommande();
				lc.setProduit(p1);
				lc.setQuantite(1);
				lc.setPrix(p1.getPrix());

				// Ajouter la ligne de commande � la map avec l'id du produit comme cl�
				Articles.put(p1.getId_produit(), lc);

				
			} else {				// Si le produit a d�j� �t� ajout� au panier
				
				
				// Incr�menter la quantit�
				lc1.setQuantite(lc1.getQuantite() + 1);

				// Ajuster le prix
				lc1.setPrix(p1.getPrix() * lc1.getQuantite());
			}

			// Retirer un produit du stock
			int qte = p1.getQuantite();
			p1.setQuantite(qte - 1);
			produitService.updateProductService(p1);
		}

		// Actualiser le panier
		List<LigneCommande> listePanier = new ArrayList<LigneCommande>();
		double prix = 0;
		for (LigneCommande lc : Articles.values()) {
			listePanier.add(lc);
			prix = prix + lc.getPrix();
		}
		panierC.setListeLC(listePanier);
		panierC.setPrixTotal(prix);

		// Recharger la liste des cat�gories et des produits
		List<Produit> prodList = produitService.getAllProductService();
		List<Categorie> catListe = categorieService.getAllCategorieService();
		model.addAttribute("prouitList", prodList);
		model.addAttribute("categorieList", catListe);
		model.addAttribute("title", "Accueil client");

		return "indexClient";
	}

	/**
	 * R�cup�rer les donn�es du panier
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String voirPanier(ModelMap model) {

		List<LigneCommande> lcList = new ArrayList<LigneCommande>();

		Panier panier = new Panier();
		panier.setPrixTotal(0.00);

		for (LigneCommande lc : Articles.values()) {

			// Cr�er la liste de ligne de commande
			lcList.add(lc);

			// D�terminer le cout total du panier
			panier.setPrixTotal(panier.getPrixTotal() + lc.getPrix());
		}

		// Actualiser le panier du client
		panierC.setListeLC(lcList);
		panierC.setPrixTotal(panier.getPrixTotal());

		model.addAttribute("panierList", lcList);
		model.addAttribute("prix", panier.getPrixTotal());

		return "panier";
	}

	
	/**
	 * Initialiser le formulaire de cr�ation d'un client
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/creerClient", method = RequestMethod.GET)
	public ModelAndView addClient(ModelMap model) {

		String viewName = "addClient";

		return new ModelAndView(viewName, "client", new Client());
	}

	/**
	 * Cr�ation d'un nouveau client
	 * 
	 * @param client
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public String ajouterClient(@ModelAttribute("client") Client client, ModelMap model) {

		// V�rifier que le client n'a pas encore de compte
		int exist = clientService.isExistClientService(client.getNom());

		if (exist == 0) {		// Si le client n'a pas encore de compte � ce nom - Cr�er le compte et continuer la proc�dure

			clientService.addClientService(client);

			return "connexionClient";

		} else {				// Si il existe d�j� un compte � ce nom - Redemander le remplissage du formulaire

			model.addAttribute("message", "Ce nom dispose d�j� d'un compte");

			return "addClient";
		}

	}

	/**
	 * Initialiser le formulaire de connexion client
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public ModelAndView seConnecter(ModelMap model) {

		String viewName = "connexionClient";

		return new ModelAndView(viewName, "client", new Client());
	}

	/**
	 * Soumettre la connexion du client
	 * 
	 * @param client
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/connecterClient", method = RequestMethod.POST)
	public String connexionClient(@ModelAttribute Client client, ModelMap model) {

		// V�rifier s'il existe un compte pour ce client
		int exist = clientService.isExistClientService(client.getNom(), client.getPassword());

		if (exist == 0) { 		// S'il n'existe pas de compte avec ces param�tres - Permettre une nouvelle tentative

			model.addAttribute("message",
					"Ce compte n'existe pas, veuillez v�rifier vos identifiants ou cr�er un compte");
			return "connexionClient";

		} else {				// Si le compte existe - Valider connexion et obtenir le r�capitulatif de la commande

			model.addAttribute("nomClient", client.getNom());

			List<LigneCommande> liste = panierC.getListeLC();
			double prix = panierC.getPrixTotal();

			model.addAttribute("panierList", liste);
			model.addAttribute("prix", prix);
			return "validationCommande";
		}

	}

	/**
	 * Supprimer un produit du panier
	 * 
	 * @param nomProd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/retirerPanier/{nomProduit}", method = RequestMethod.GET)
	public String retirerPanier(@ModelAttribute("nomProduit") String nomProd, ModelMap model) {

		// Trouver le produit
		Produit produit = produitService.getProductByNameService(nomProd);
		
		// D�terminer la quantit� qui �tait demand�e par le client
		int qte = Articles.get(produit.getId_produit()).getQuantite();
		
		// Ajouter la quantit� au stock
		produit.setQuantite(produit.getQuantite()+qte);
		produitService.updateProductService(produit);
		
		// Retirer le produit de la map des produits demand�s par le client
		Articles.remove(produit.getId_produit());
		
		// R�cup�rer une liste des produits du panier
		List<LigneCommande> lcList = new ArrayList<LigneCommande>();
		Panier panier = new Panier();
		panier.setPrixTotal(0.00);

		for (LigneCommande lc : Articles.values()) {

			// Cr�er la liste de ligne de commande
			lcList.add(lc);

			// D�terminer le cout total du panier
			panier.setPrixTotal(panier.getPrixTotal() + lc.getPrix());
		}

		// Actualiser les donn�es du panier
		panierC.setListeLC(lcList);
		panierC.setPrixTotal(panier.getPrixTotal());

		model.addAttribute("panierList", lcList);
		model.addAttribute("prix", panier.getPrixTotal());

		return "panier";
	}

	/**
	 * Finaliser la commande
	 * 
	 * @param client
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/final/{nomClient}", method = RequestMethod.GET)
	public String finaliser(@ModelAttribute("nomClient") String nomClient, ModelMap model) {

		// Cr�er une nouvelle commande
		Commande com = new Commande();
		
		// R�cup�rer le client correspondant au nom
		Client client = clientService.getClientByNameDao(nomClient);
		
		// R�cup�rer la date du jour
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		com.setDate_commande(date);

		// R�cup�rer la liste des produits command�s
		List<LigneCommande> lcList = new ArrayList<LigneCommande>();
		for (LigneCommande lc : Articles.values()) {
			lcList.add(lc);
		}

		// Injecter les donn�es de la commande
		panierC.setClientP(client);
		com.setClient(client);
		com.setPanier(panierC);
		
		// Enregistrer le panier dans la base de donn�es
		panierService.addPanierService(panierC);
		
		// Enregistrer la commande dans la base de donn�es
		commandeService.addCommandeService(com);

		// R�initialiser le panier
		panierC.setListeLC(null);
		panierC.setPrixTotal(0.00);
		panierC.setClientP(null);

		// R�initialiser la map des articles demand�s par le client
		Articles.clear();

		List<Categorie> listeCat = categorieService.getAllCategorieService();
		model.addAttribute("title", "Accueil client");
		model.addAttribute("categorieList", listeCat);
		model.addAttribute("message", "Merci pour votre commande");

		return "indexClient";
	}

}
