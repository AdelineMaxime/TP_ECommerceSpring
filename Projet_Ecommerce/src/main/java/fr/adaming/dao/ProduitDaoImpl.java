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
@Transactional
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
	@Transactional
	public void addProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		session.save(produit);

	}

	@Override
	@Transactional
	public void deleteProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		session.delete(produit);
	}

	@Override
	@Transactional
	public void updateProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		session.saveOrUpdate(produit);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produit> getAllProductDao() {

		Session session = sf.getCurrentSession();
		String req = "FROM Produit";
		Query query = session.createQuery(req);
		List<Produit> liste = query.list();

		return liste;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produit> getProductByCatDao(Categorie categorie) {

		Session session = sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.categorie.id_categorie=:id_cat";
		Query query = session.createQuery(req);
		query.setParameter("id_cat", categorie.getId_categorie());

		List<Produit> liste = query.list();

		return liste;
	}

	@Override
	@Transactional(readOnly = true)
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
