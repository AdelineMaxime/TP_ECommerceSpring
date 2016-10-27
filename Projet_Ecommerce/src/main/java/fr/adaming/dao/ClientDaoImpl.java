package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public void addClientDao(Client client) {

		Session session = sf.getCurrentSession();
		session.save(client);
		
	}

	@Override
	public int isExistClientDao(String nom, String password) {

		Session session = sf.getCurrentSession();
		String req = "SELECT c FROM Client c WHERE c.nom=:nom AND c.password=:mdp";
		Query query = session.createQuery(req);
		query.setParameter("nom", nom);
		query.setParameter("mdp", password);
		
		query.list();
		
		return 0;
	}

}
