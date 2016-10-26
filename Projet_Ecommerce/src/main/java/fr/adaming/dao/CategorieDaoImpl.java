package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Categorie;

@Repository
@Transactional
public class CategorieDaoImpl implements ICategorieDao {
	
	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	@Transactional
	public void addCategorieDao(Categorie categorie) {
		
		Session session = sf.getCurrentSession();
		session.save(categorie);

	}

	@Override
	@Transactional
	public void deleteCategorieDao(Categorie categorie) {
		
		Session session = sf.getCurrentSession();
		session.delete(categorie);

	}

	@Override
	@Transactional
	public void updateCategorieDao(Categorie categorie) {
		
		Session session = sf.getCurrentSession();
		session.saveOrUpdate(categorie);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Categorie> getAllCategorieDao() {
		
		Session session = sf.getCurrentSession();
		String req="From Categorie";
		Query query= session.createQuery(req);
		List<Categorie> catListe= query.list();
		
		return catListe;
	}

}
