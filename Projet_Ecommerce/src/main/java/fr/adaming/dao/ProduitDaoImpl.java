package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao {

	@Autowired
	private SessionFactory sf;

	/**
	 * Ajouter un produit
	 */
	@Override
	public void addProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		session.save(produit);

	}

	/**
	 * Obtenir un produit par son nom
	 */
	@Override
	public Produit getProductByNameDao(String name) {

		Session session = sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.nom=:nom";
		Query query = session.createQuery(req);
		query.setParameter("nom", name);

		return (Produit) query.uniqueResult();

	}

	/**
	 * Obtenir tous les produits
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProductDao() {

		Session session = sf.getCurrentSession();
		String req = "FROM Produit";
		Query query = session.createQuery(req);

		return query.list();
	}

	/**
	 * Supprimer un produit
	 */
	@Override
	public void deleteProductDao(Produit produit) {

		Session session = sf.getCurrentSession();

		String req = "Delete from Produit p where p.id_produit=:id";
		Query query = session.createQuery(req);
		query.setParameter("id", produit.getId_produit());
		query.executeUpdate();

	}

	/**
	 * Modifier un produit
	 */
	@Override
	public void updateProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		String req = "UPDATE Produit p SET p.nom=:nom, p.description=:descr, p.prix=:prix, p.quantite=:qte WHERE p.id_product=:id";
		Query query = session.createQuery(req);
		query.setParameter("nom", produit.getNom());
		query.setParameter("descr", produit.getDescription());
		query.setParameter("prix", produit.getPrix());
		query.setParameter("qte", produit.getQuantite());
		query.setParameter("id", produit.getId_produit());

		query.executeUpdate();

	}


	/**
	 * Obtenir tous les produits d'une catégorie
	 */
	@Override
	public List<Produit> getProductByCatDao(int id) {

		Session session = sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.categorie.id_categorie=:id";
		Query query = session.createQuery(req);
		query.setParameter("id", id);

		@SuppressWarnings("unchecked")
		List<Produit> liste = query.list();

		return liste;
	}

}
