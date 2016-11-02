package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Panier;

@Repository
public class PanierDaoImpl implements IPanierDao {

	
	@Autowired
	private SessionFactory sf;
	
	/**
	 * Créer un nouveau panier
	 */
	@Override
	public void addPanierDao(Panier panier) {

		Session session = sf.openSession();
		session.save(panier);
		
	}

}
