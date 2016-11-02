package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Commande;

@Repository
public class CommandeDaoImpl implements ICommandeDao {

	
	@Autowired
	private SessionFactory sf;
	
	/**
	 * Créer une nouvelle commande
	 */
	@Override
	public void addCommandeDao(Commande commande) {

		Session session = sf.openSession();
		session.save(commande);
		
	}

}
