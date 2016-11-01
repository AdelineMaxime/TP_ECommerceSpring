package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ILigneCommDao;
import fr.adaming.model.LigneCommande;

@Service("ligneCommServiceBean")
public class LigneCommServiceImpl implements ILigneCommService {

	
	@Autowired
	private ILigneCommDao ligneCommDao;
	
	/**
	 * Ajouter une ligne de commande
	 */
	@Override
	public void addLigneCommService(LigneCommande lc) {

		ligneCommDao.addLigneCommDao(lc);
	}

	/**
	 * Supprimer une ligne de commande
	 */
	@Override
	public void deleteLigneCommService(LigneCommande lc) {

		ligneCommDao.deleteLigneCommDao(lc);
	}

	/**
	 * Modifier une ligne de commande
	 */
	@Override
	public void updateLigneCommService(int qte) {

		ligneCommDao.updateLigneCommDao(qte);
	}

	/** 
	 * Obtenir toutes les lignes de commande
	 */
	@Override
	public List<LigneCommande> getAllLigneCommService() {

		return ligneCommDao.getAllLigneCommDao();
	}

}
