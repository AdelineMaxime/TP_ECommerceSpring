package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;
	
	
	/**
	 * Ajouter un client
	 */
	@Override
	public void addClientDao(Client client) {

		Session session = sf.getCurrentSession();
		session.save(client);
		
	}

	/**
	 * Vérifier s'il existe un compte avec le nom et le mdp proposés
	 * Retourne 0 s'il n'en existe pas
	 */
	@Override
	public int isExistClientDao(String nom, String password) {

		Session session = sf.getCurrentSession();
		String req = "SELECT c FROM Client c WHERE c.nom=:nom AND c.password=:mdp";
		Query query = session.createQuery(req);
		query.setParameter("nom", nom);
		query.setParameter("mdp", password);
		
		return query.list().size();
	}
	
	/**
	 * Vérifier s'il existe déjà un compte avec le même nom de client
	 * Retourne 0 s'il n'en existe pas
	 */
	@Override
	public int isExistClientDao(String nom) {

		Session session = sf.getCurrentSession();
		String req = "SELECT c FROM Client c WHERE c.nom=:nom";
		Query query = session.createQuery(req);
		query.setParameter("nom", nom);
		
		return query.list().size();
	}
	
	/**
	 * Récupérer un client par son nom
	 * 
	 * @param nomClient
	 * @return
	 */
	@Override
	public Client getClientByNameDao(String nomClient) {
		
		Session session = sf.getCurrentSession();
		String req = "SELECT c FROM Client c WHERE c.nom=:nom";
		Query query = session.createQuery(req);
		query.setParameter("nom", nomClient);

		return  (Client) query.uniqueResult();
		
	}

}
