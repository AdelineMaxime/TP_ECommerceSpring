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
	
	@Override
	public void addLigneCommService(LigneCommande lc) {

		ligneCommDao.addLigneCommDao(lc);
	}

	@Override
	public void deleteLigneCommService(LigneCommande lc) {

		ligneCommDao.deleteLigneCommDao(lc);
	}

	@Override
	public void updateLigneCommService(int qte) {

		ligneCommDao.updateLigneCommDao(qte);
	}

	@Override
	public List<LigneCommande> getAllLigneCommService() {

		return ligneCommDao.getAllLigneCommDao();
	}

}
