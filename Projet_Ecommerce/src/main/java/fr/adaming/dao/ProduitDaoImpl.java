package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao {

	// Paramètres
	// -------------------------------------------------------------------------------------------------------------
	@Autowired
	private SessionFactory sf;

	// Setter
	// -------------------------------------------------------------------------------------------------------------------
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	// Méthodes
	// -----------------------------------------------------------------------------------------------------------------
	@Override
	public void addProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		session.save(produit);

	}

	@Override
	public void deleteProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		String req = "DELETE FROM Produit p WHERE p.id_produit=:id";
		Query query = session.createQuery(req);
		query.setParameter("id", produit.getId_produit());
		query.executeUpdate();
	}

	@Override
	public void updateProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		String req = "UPDATE Produit p SET p.nom=:nom, p.description=:descr, p.prix=:prix, p.quantite=:qte WHERE p.id_produit=:id";
		Query query = session.createQuery(req);
		query.setParameter("nom", produit.getNom());
		query.setParameter("descr", produit.getDescription());
		query.setParameter("prix", produit.getPrix());
		query.setParameter("qte", produit.getQuantite());
		query.setParameter("id", produit.getId_produit());
		query.executeUpdate();
	}

	@Override
	public List<Produit> getAllProductDao() {

		Session session = sf.getCurrentSession();
		String req = "FROM Produit";
		Query query = session.createQuery(req);
		List<Produit> liste = query.list();

		return liste;
	}

	@Override
	public List<Produit> getProductByCatDao(Categorie categorie) {

		Session session = sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.categorie.id_categorie=:id_cat";
		Query query = session.createQuery(req);
		query.setParameter("id_cat", categorie.getId_categorie());

		List<Produit> liste = query.list();

		return liste;
	}

	@Override
	public Produit getProductByNameDao(String name) {

		Session session = sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.nom=:nom_prod";
		Query query = session.createQuery(req);
		query.setParameter("nom_prod", name);

		List<Produit> liste = query.list();
		Produit prod = liste.get(0);

		return prod;
	}

}
