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

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public void addProductDao(Produit produit) {

		Session session = sf.getCurrentSession();
		session.save(produit);
		
	}


	@Override
	public Produit getProductByNameDao(String name) {

		Session session = sf.getCurrentSession();
		String req = "SELECT p FROM Produit p WHERE p.nom=:nom";
		Query query = session.createQuery(req);
		query.setParameter("nom", name);
		
	
		
		return (Produit) query.uniqueResult();
		
	}


	@Override
	public List<Produit> getAllProductDao() {

		Session session = sf.getCurrentSession();
		String req = "FROM Produit";
		Query query = session.createQuery(req);
		
		return query.list();
	}


	@Override
	public void deleteProductDao(Produit produit) {

		Session session =sf.getCurrentSession();
		Produit p = (Produit) session.get(Produit.class, produit.getId_produit());
		session.delete(p);
		
	}


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


	@Override
	public List<Produit> getProductByCatDao(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void selectProductDao(Produit produit) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Produit> getAllSelectedProductDao() {
		// TODO Auto-generated method stub
		return null;
	}


}
