package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fr.adaming.model.Categorie;

@Repository
public class CategorieDaoImpl implements ICategorieDao {
	
	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	

	@Override
	public void addCategorieDao(Categorie categorie) {
		
		Session session = sf.getCurrentSession();
		session.save(categorie);

	}

	@Override
	public void deleteCategorieDao(Categorie categorie) {
		
		Session session = sf.getCurrentSession();
		
		String req="Delete from Categorie "
		

	}

	@Override
	public void updateCategorieDao(Categorie categorie) {
		
		Session session = sf.getCurrentSession();
		session.saveOrUpdate(categorie);

	}

	@Override
	public List<Categorie> getAllCategorieDao() {
		
		Session session = sf.getCurrentSession();
		String req="From Categorie";
		Query query= session.createQuery(req);
		List<Categorie> catListe= query.list();
		
		return catListe;
	}


	@Override
	public Categorie getCategorieByIdDao(int id_categorie) {
		
		
		
		return null;
	}
	
	

}
